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

    override fun peek(): T? = storage.firstOrNull()

    override fun dequeue(): T? = storage.removeFirstOrNull()

    override fun enqueue(element: T) = storage.add(element)
}

fun main() {
    QueueImpl<Int>().apply {
        enqueue(1)
        println("Add element 1")
        enqueue(2)
        println("Add element 2")
        enqueue(3)
        println("Add element 3")

        // results should be FIFO: 1, 2, 3
        println("Peek elements one by one: ${this.peek()}, ${this.peek()}, ${this.peek()}")
    }
}
