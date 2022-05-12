package com.example.algorithms.traversal

import com.example.algorithms.traversal.Traversal.TraversalPath.LEFT
import com.example.algorithms.traversal.Traversal.TraversalPath.RIGHT

class Traversal {

    // knowledge source: https://www.youtube.com/watch?v=IpyCqRmaKW4
    //       A
    //     /  \
    //    B    C
    //   /  \
    // D    E
    //     /
    //    F

    fun checkVertex(path: TraversalPath? = null) {
        // when after check left/right there won't be any next vertex
        // then go back to previous vertex
        if (path == null) return

        println("Checked as visited")

        // recur to left subtree
        checkVertex(LEFT)

        // recur to right subtree
        checkVertex(RIGHT)
    }

    enum class TraversalPath { LEFT, RIGHT }


    fun test() {
        checkVertex()
    }

}
