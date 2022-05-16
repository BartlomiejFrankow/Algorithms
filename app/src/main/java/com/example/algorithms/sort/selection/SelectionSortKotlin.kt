package com.example.algorithms.sort.selection

// Time complexity: O(n^2)
// Quadratic time complexity can't resolve big problems
class SelectionSortKotlin {

    fun sortIntegersAscending(array: Array<Int>) {
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

        println("SELECTION SEARCH RESULTS: ${array.contentToString()}")
    }

    private fun exchange(array: Array<Int>, indexToBeSwap: Int, swapIndex: Int) {
        val swap = array[indexToBeSwap]

        array[indexToBeSwap] = array[swapIndex]
        array[swapIndex] = swap
    }

}
