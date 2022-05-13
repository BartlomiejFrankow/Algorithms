package com.example.algorithms.dataStructures.stacks.kotlin

class LinkedStactOfStringsKotlin {
    private var first: Node? = null

    // Time complexity: every operation takes constant time in the worst case O(n)
    // Space complexity: stack with N times uses ~ 40N bytes
    data class Node(
        var item: String? = null,
        var next: Node? = null
    )

    val isEmpty = first == null

    fun push(item: String?) {
        val oldFirst = first

        first = Node()
        first?.item = item
        first?.next = oldFirst
    }

    fun pop(): String? {
        val item = first?.item

        first = first?.next
        return item
    }
}
