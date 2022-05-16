package com.example.algorithms.sort.insertion

import com.example.algorithms.sort.exchange
import kotlin.system.measureTimeMillis

// Time complexity: O(1/4 n^2)
// Faster than selection sort in best scenario (partly sorted array) but lower in worst (desc input array)
class InsertionSort {

    fun sortIntegersAscending(array: Array<Int>) {
        println("INSERTION SORT INPUT DATA: ${array.contentToString()}")
        val measuredTime = measureTimeMillis {
            val size = array.size

            for (item in 0 until size) {

                for (nextItem in item downTo 1) {
                    // Compare 'nextItem' with previous one. If previous item has higher value then exchange value between indexes
                    // If previous item has lower value then stop and do next item check
                    if (array[nextItem] < array[nextItem - 1]) {
                        exchange(array, nextItem, nextItem - 1)
                    } else {
                        break
                    }
                }

            }
        }

        println("INSERTION SORT TIME: $measuredTime, results: ${array.contentToString()}")
    }

}
