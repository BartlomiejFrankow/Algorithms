package com.example.algorithms.dataStructures.stacks.kotlin

/*
The quickies and the most efficient algorithm from 'stacks' package
Every operation takes constant amortized time
Less wasted space
*/

class ResizingArrayStackOfStringKotlin internal constructor() {
    private var stack: Array<String?> = arrayOfNulls(1)
    private var n = 0

    val isEmpty: Boolean
        get() = n == 0

    // Double size of array when array is full
    fun push(item: String?) {
        if (n == stack.size) {
            resize(2 * stack.size)
        }
        stack[n++] = item
    }

    // Divide size of array by half when array is one-quarter full
    fun pop(): String? {
        val item = stack[--n]
        stack[n] = null
        if (n > 0 && n == stack.size / 4) {
            resize(stack.size / 2)
        }
        return item
    }

    // Inserting first 'n' items takes time proportional to O(n) - not O(n^2)
    private fun resize(capacity: Int) {
        val copy = arrayOfNulls<String>(capacity)
        for (i in 0 until n) {
            copy[i] = stack[i]
        }
        stack = copy
    }
}

