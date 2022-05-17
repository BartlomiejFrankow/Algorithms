package com.example.algorithms.sort.selection

import com.example.algorithms.sort.exchange
import kotlin.system.measureTimeMillis

// Time complexity: O(n^2/2)
// Quadratic time complexity divided by 2 can't resolve big problems
class SelectionSort {

    fun sortIntegersAscending(array: Array<Int>, start: Int, end: Int) {
        println("SELECTION SORT INPUT DATA: ${array.contentToString()}")

        val measuredTime = measureTimeMillis {

            for (item in start until end) {
                var minimum = item

                // search for value lower than value from previous index
                for (nextItem in item + 1 until end) {
                    if (array[nextItem] < array[minimum]) minimum = nextItem
                }

                // when lower value will be found then swap it with previous index
                exchange(array, item, minimum)

                // ...and so on check for a swap for every item in list
            }
        }
        println("SELECTION SORT TIME: $measuredTime, results: ${array.contentToString()}")
    }

}
