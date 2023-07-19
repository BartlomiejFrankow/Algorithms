package com.example.algorithms.dataStructures.queue.newexample

interface Queue<T> {

    val count: Int

    val isEmpty: Boolean

    fun peek(): T?

    fun enqueue(element: T): Boolean

    fun dequeue(): T?
}
