package com.example.algorithms.dataStructures.stacks.kotlin

class FixedCapacityStackOfStringsKotlin {
    private lateinit var stack: Array<String?>
    private var n = 0

    fun FixedCapacityStackOfStringsJava(capacity: Int) {
        stack = arrayOfNulls(capacity)
    }

    fun isEmpty() = n == 0

    fun push(item: String?) {
        stack[n++] = item
    }

    // Loitering - holding a reference to an object when is no longer needed
    // Loitering pop
    fun loiteringPop() = stack[--n]

    // This version avoids loitering. Garbage collector can reclaim memory only if no outstanding references
    fun pop(): String? {
        val item = stack[--n]
        stack[n] = null
        return item
    }
}
