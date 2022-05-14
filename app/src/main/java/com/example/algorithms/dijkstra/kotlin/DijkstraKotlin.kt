package com.example.algorithms.dijkstra.kotlin

import com.example.algorithms.help.StdIn
import com.example.algorithms.help.StdOut
import java.util.*

/*
* When algorithm encounters an operator surrounded by two values
* within parentheses it leaves the result on the value stack.
* */

class DijkstraKotlin {
    /*
     * Java evaluate:
     * args = "(1 + ((2 + 3) * (4 * 5)))"
     * result is: 101.0
     */
    fun main(args: Array<String>) {
        val ops = Stack<String>()
        val vals = Stack<Double>()
        while (!StdIn.isEmpty()) {
            val string = StdIn.readString()

            when (string) {
                "(" -> {
                    // do nothing
                }
                "+" -> ops.push(string)
                "*" -> ops.push(string)
                ")" -> {
                    val op = ops.pop()
                    if (op == "+") vals.push(vals.pop() + vals.pop())
                    else if (op == "*") vals.push(vals.pop() + vals.pop())
                }
                else -> vals.push(string.toDouble())
            }
        }
        StdOut.println(vals.pop())
    }
}
