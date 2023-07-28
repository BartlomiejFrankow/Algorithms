package com.example.algorithms.sort.selection

import com.example.algorithms.sort.exchange
import kotlin.system.measureTimeMillis

/*Time complexity:
* Worst: O(n^2/2)
* Average: O(n^2/2)
* Best: O(n^2/2)
* In place: Yes
* Stable: No
* Remarks: uses N exchanges
*
* Quadratic time complexity divided by 2 can't resolve big problems
*/
class SelectionSort {

    fun sortIntegersAscending(array: Array<Int>, start: Int, end: Int) {
        println("SELECTION SORT INPUT DATA: ${array.contentToString()}")

        val measuredTime = measureTimeMillis {

            for (itemIndex in start until end) {
                var minValueIndex = itemIndex

                // search for value lower than value from nextItemIndex
                for (nextItemIndex in itemIndex + 1 until end) {
                    if (array[nextItemIndex] < array[minValueIndex]) minValueIndex = nextItemIndex
                }

                // when lower value will be found then swap it with previous index
                exchange(array, itemIndex, minValueIndex)

                // ...and so on check for a swap for every item in list
            }
        }
        println("SELECTION SORT TIME: $measuredTime ms, results: ${array.contentToString()}")
    }

}
