package com.example.algorithms.sort.selection

import com.example.algorithms.sort.exchange

// Time complexity: O(n^2/2)
// Quadratic time complexity divided by 2 can't resolve big problems
class SelectionSort {

    fun sortIntegersAscending(array: Array<Int>) {
        val beginTime = System.nanoTime()

        println("SELECTION SEARCH INPUT DATA: ${array.contentToString()}")

        val size = array.size

        for (item in 0 until size) {
            var minimum = item

            // search for value lower than value from previous index
            for (nextItem in item + 1 until size) {
                if (array[nextItem] < array[minimum]) minimum = nextItem
            }

            // when lower value will be found then swap it with previous index
            exchange(array, item, minimum)

            // ...and so on check for a swap for every item in list
        }

        val endTime = System.nanoTime()

        println("SELECTION SEARCH RESULTS: ${array.contentToString()}, time: ${endTime - beginTime}")
    }

}
