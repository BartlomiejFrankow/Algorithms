package com.example.algorithms.dataStructures.tree.heap

import java.util.Arrays

class MinIntHeap {
    private var capacity: Int = 10
    var size: Int = 0

    /**
     * Keep it in mind IntArray is storing as default 0 values
     * after set up array size.
     * For example when IntArray size is 10 then list[0-9]
     * will result with 0 value as default.
     * */
    private var items = IntArray(capacity)

    private fun getLeftChildIndex(parentIndex: Int) = 2 * parentIndex + 1
    private fun getRightChildIndex(parentIndex: Int) = 2 * parentIndex + 2
    private fun getParentIndex(childIndex: Int) = (childIndex - 1) / 2

    private fun hasLeftChild(index: Int) = getLeftChildIndex(index) < size
    private fun hasRightChild(index: Int) = getRightChildIndex(index) < size
    private fun hasParent(index: Int) = getParentIndex(index) >= 0

    private fun leftChild(index: Int) = items[getLeftChildIndex(index)]
    private fun rightChild(index: Int) = items[getRightChildIndex(index)]
    private fun parent(index: Int) = items[getParentIndex(index)]

    /**
     * Swap tree places for two different indexes, but do not sort them.
     * */
    private fun swap(firstIndex: Int, secondIndex: Int) {
        val itemToSwap = items[firstIndex]
        items[firstIndex] = items[secondIndex]
        items[secondIndex] = itemToSwap
    }

    /**
     * If capacity of current array is full, them make copy
     * of array and double current capacity for new array.
     * */
    private fun ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2)
            capacity *= 2
        }
    }

    /**
     * Get root of heap if exist
     * */
    fun peek(): Int? {
        if (size == 0) return null
        return items[0]
    }

    /**
     * Get value from index if exist
     * */
    fun peekAt(index: Int): Int? {
        if (size == 0) return null
        return items[index]
    }

    /**
     * Remove minimum element from array if exist
     * */
    fun poll(): Int? {
        if (size == 0) return null
        val item = items[0]

        items[0] = items[size - 1]

        size--

        heapifyDown()

        return item
    }

    fun add(value: Int) {
        ensureExtraCapacity()
        items
        items[size] = value
        size++
        heapifyUp()
    }

    /**
     * Sort data from lower (up) to biggest (down) in tree after add new element
     * */
    private fun heapifyUp() {
        var index = size - 1 // last element index

        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index)
            index = getParentIndex(index)
        }
    }

    /**
     * Sort data from lower (up) to biggest (down) in tree after remove smallest element (root)
     * */
    private fun heapifyDown() {
        var index = 0

        while (hasLeftChild(index)) {
            var smallerChildIndex = getLeftChildIndex(index)

            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index)
            }

            if (items[index] < items[smallerChildIndex]) {
                break
            } else {
                swap(index, smallerChildIndex)
            }

            index = smallerChildIndex
        }
    }
}

fun main() {
    val heap = MinIntHeap()
    heap.add(10)
    heap.add(20)
    heap.add(15)
    heap.add(17)
    heap.add(8)

    for (i in 0 until heap.size) {
        print("[${heap.peekAt(i)}] ")
    }
}
