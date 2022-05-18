package com.example.algorithms.sort.shell

import com.example.algorithms.help.StdOut
import com.example.algorithms.sort.exchange
import kotlin.system.measureTimeMillis

// Time complexity: O(n^3/2)
class ShellSortKotlin {

    fun sortIntegersAscending(array: Array<Int>) {
        StdOut.println("SHELL SORT KOTLIN INPUT DATA: " + array.contentToString())

        val measuredTime = measureTimeMillis {
            var sequence = 1
            while (sequence < array.size / 3) {
                sequence = 3 * sequence + 1 // 1, 4, 13, 40, 121, 364...
            }
            while (sequence >= 1) {
                for (i in sequence until array.size) {
                    var j = i
                    while (j >= sequence && array[j] < array[j - sequence]) {
                        exchange(array, j, j - sequence)
                        j -= sequence
                    }
                }
                sequence /= 3
            }
        }

        StdOut.println("SHELL SORT KOTLIN TIME: $measuredTime, results: " + array.contentToString())
    }
}