package com.example.algorithms.sort.shuffle

import com.example.algorithms.help.StdRandom
import com.example.algorithms.sort.exchange
import kotlin.system.measureTimeMillis

// Time complexity: O(n)
class Shuffle {
    fun randomize(array: Array<Int>) {
        println("SHUFFLE SORT INPUT DATA: ${array.contentToString()}")

        val measuredTime = measureTimeMillis {
            for (item in array.indices) {
                val random = StdRandom.uniform(item + 1)
                exchange(array, item, random)
            }
        }

        println("SHUFFLE SORT TIME: $measuredTime, results: ${array.contentToString()}")
    }
}
