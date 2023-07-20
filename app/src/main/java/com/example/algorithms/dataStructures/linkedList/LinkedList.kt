package com.example.algorithms.dataStructures.linkedList

class LinkedList<T : Any> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty() = size == 0

    override fun toString() = if (isEmpty()) {
        "Empty list"
    } else {
        head.toString()
    }

    fun push(value: T) {
        head = Node(value = value, next = head)

        // in case of empty list new node is head and tail
        if (tail == null) {
            tail = head
        }

        size++
    }

    /**
     * `chainPush` works same as `push` but allows to use it on the
     * same list one after another like: "list.chainPush(1).chainPush(2)"
     * `append` can be done in same way by returning `: LinkedList<T> = apply { }`
     * */
    fun chainPush(value: T): LinkedList<T> = apply {
        head = Node(value = value, next = head)

        // in case of empty list new node is head and tail
        if (tail == null) {
            tail = head
        }

        size++
    }


    // push the value into the tail
    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }

        val newNode = Node(value)
        tail!!.next = newNode
        tail = newNode

        size++
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }

        return currentNode
    }

    // insert after provided node
    fun insert(value: T, afterNode: Node<T>) {

        if (tail == afterNode) {
            append(value)
            return
        }

        afterNode.next = Node(value = value, next = afterNode.next)

        size++
    }

    // remove item from front elements
    fun pop() {
        if (isEmpty()) return

        head = head?.next

        size--

        if (isEmpty()) tail = null
    }

    fun removeLast() {
        val head = head ?: return

        if (head.next == null) pop()

        var prev = head
        var current = head

        var next = current.next

        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev
        size--
    }

    fun removeAfter(node: Node<T>) {
        if (node.next == tail) {
            tail = node
        }

        node.next?.let { size-- }

        // omit node between
        node.next = node.next?.next
    }

    /**
     * Runner technique
     * `slow` loop is going 2 times slower compare to `fast` one.
     * When `fast` will finish `slow` will be in the middle.
     * */
    fun getMiddleNode(): Node<T>? {
        var slow = this.nodeAt(0)
        var fast = this.nodeAt(0)

        while (fast != null) {
            fast = fast.next

            if (fast != null) {
                fast = fast.next
                slow = slow?.next
            }
        }

        return slow
    }

    fun reversed(): LinkedList<T> {
        val results = LinkedList<T>()
        val head = this.nodeAt(0)

        head?.let { addInReverse(results, it) }

        return results
    }

    private fun <T : Any> addInReverse(list: LinkedList<T>, node: Node<T>) {
        val next = node.next

        next?.let { addInReverse(list, it) }

        list.append(node.value)
    }
}
