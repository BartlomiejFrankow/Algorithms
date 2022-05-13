package com.example.algorithms.dataStructures.stacks.kotlin

class FixedCapacityStackOfStringsKotlin {
    private lateinit var s: Array<String?>
    private var n = 0

    fun FixedCapacityStackOfStringsJava(capacity: Int) {
        s = arrayOfNulls(capacity)
    }

    fun isEmpty() = n == 0

    fun push(item: String?) {
        s[n++] = item
    }

    // Loitering - holding a reference to an object when is no longer needed
    // Loitering pop
    fun loiteringPop() = s[--n]

    // This version avoids loitering. Garbage collector can reclaim memory only if no outstanding references
    fun pop(): String? {
        val item = s[--n]
        s[n] = null
        return item
    }
}
