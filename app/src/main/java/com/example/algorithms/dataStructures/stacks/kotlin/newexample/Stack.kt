package com.example.algorithms.dataStructures.stacks.kotlin.newexample

interface Stack<T> {

    fun pop(): T?

    fun push(element: T): Boolean

    fun peek(): T?

    val count: Int

    val isEmpty: Boolean
        get() = count == 0
}