package com.example.algorithms.dataStructures.linkedList

data class Node<T : Any>(
    var value: T,
    var next: Node<T>? = null
) {

    override fun toString(): String {
        return if (next != null) {
            "$value -> $next"
        } else {
            "$value"
        }
    }

    fun printInReverse() {
        next?.printInReverse()

        /**
         * code below will run after `next` will be null as many
         * times as `next?.printInReverse()` was run before
         * */
        next?.let {
            print(" -> ")
        }
        print(value.toString())
    }
}
