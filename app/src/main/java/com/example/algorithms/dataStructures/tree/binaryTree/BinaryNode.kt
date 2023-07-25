package com.example.algorithms.dataStructures.tree.binaryTree

/**
 * Time complexity of Binary Tree is O(n)
 * */
class BinaryNode(var data: Int) {
    private var left: BinaryNode? = null
    private var right: BinaryNode? = null

    fun insert(value: Int) {
        if (value <= data) {
            if (left == null) {
                left = BinaryNode(value)
            } else {
                left?.insert(value)
            }
        } else {
            if (right != null) {
                right!!.insert(value)
            } else {
                right = BinaryNode(value)
            }
        }
    }

    fun contains(value: Int): Boolean {
        return when {
            value == data -> true
            value < data -> {
                if (left != null) {
                    left!!.contains(value)
                } else {
                    false
                }
            }

            else -> { // value > data
                if (right != null) {
                    right!!.contains(value)
                } else {
                    false
                }
            }
        }
    }

    fun printInOrder() {
        left?.printInOrder()
        println(data)
        right?.printInOrder()
    }

    fun printPreOrder() {
        println(data)
        left?.printPreOrder()
        right?.printPreOrder()
    }

    fun printPostOrder() {
        left?.printPostOrder()
        right?.printPostOrder()
        println(data)
    }

}

fun main() {
    BinaryNode(10).apply {
        insert(5)
        insert(8)
        insert(15)

        println("In order:")
        printInOrder()

        println("Pre order:")
        printPreOrder()

        println("Post order:")
        printPostOrder()
    }
}
