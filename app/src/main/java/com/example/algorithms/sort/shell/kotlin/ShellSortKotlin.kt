package com.example.algorithms.sort.shell.kotlin

import com.example.algorithms.help.StdOut
import com.example.algorithms.sort.exchange

// Time complexity: O(n^3/2)
class ShellSortKotlin {
    fun sortIntegersAscending(array: Array<Int>) {
        val beginTime = System.currentTimeMillis()
        StdOut.println("SHELL SORT KOTLIN INPUT DATA: " + array.contentToString())
        val arraySize = array.size
        var sequence = 1
        while (sequence < arraySize / 3) {
            sequence = 3 * sequence + 1 // 1, 4, 13, 40, 121, 364...
        }
        while (sequence >= 1) {
            for (i in sequence until arraySize) {
                var j = i
                while (j >= sequence && array[j] < array[j - sequence]) {
                    exchange(array, j, j - sequence)
                    j -= sequence
                }
            }
            sequence /= 3
        }
        val endTime = System.currentTimeMillis()
        StdOut.println("SHELL SORT KOTLIN TIME: ${endTime - beginTime}, results: " + array.contentToString())
    }
}
