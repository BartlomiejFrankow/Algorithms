package com.example.algorithms.dataStructures.queue.kotlin

class LinkedQueueOfStringsKotlin {
    private var first: Node? = null
    private var last: Node? = null

    private inner class Node {
        var item: String? = null
        var next: Node? = null
    }

    private val isEmpty: Boolean
        get() = first == null

    fun enqueue(item: String?) {
        val oldLast = last

        last = Node()
        last!!.item = item
        last!!.next = null

        if (isEmpty) {
            first = last
        } else {
            oldLast!!.next = last
        }
    }

    fun dequeue(): String? {
        val item = first!!.item

        first = first!!.next

        if (isEmpty) {
            last = null
        }
        return item
    }
}
