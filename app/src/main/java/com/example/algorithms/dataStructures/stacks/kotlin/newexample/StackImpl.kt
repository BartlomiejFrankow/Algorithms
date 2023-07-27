package com.example.algorithms.dataStructures.stacks.kotlin.newexample

/**
 * Stack are adding elements one after another, but getting elements
 * starts from the last one and moves to the first one.
 * That's because stacks are LIFO(last in first out).
 */
class StackImpl<T> : Stack<T> {

    private var storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override fun pop(): T? {
        return storage.removeLastOrNull()
    }

    override fun push(element: T) {
        storage.add(element)
    }
}

fun String.isValidParentheses(): Boolean {
    val stack = StackImpl<Char>()

    for (char in this) {
        when (char) {
            '(' -> stack.push(char)
            ')' -> {
                if (stack.isEmpty) {
                    return false
                } else {
                    stack.pop()
                }
            }
        }
    }

    return stack.isEmpty
}
