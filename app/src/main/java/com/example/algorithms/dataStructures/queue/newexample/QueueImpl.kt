package com.example.algorithms.dataStructures.queue.newexample

/**
 * Queue are adding elements one after another, and getting
 * elements starts from the first one and moves to the last one.
 * That's because queues are FIFO(first in first out).
 */
class QueueImpl<T> : Queue<T> {

    private val storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override val isEmpty: Boolean
        get() = count == 0

    override fun peek(): T? {
        val first = storage.getOrNull(0)

        // additionally remove from queue
        if (first != null) storage.removeAt(0)

        return first
    }

    override fun dequeue(): T? {
        return if (isEmpty) {
            null
        } else {
            storage.removeAt(0)
        }
    }

    override fun enqueue(element: T): Boolean {
        return storage.add(element)
    }
}