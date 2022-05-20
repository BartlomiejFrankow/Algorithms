package com.example.algorithms.sort.merge.kotlin

import com.example.algorithms.sort.selection.SelectionSort

/*Time complexity:
* Worst: O(n log n)
* Average: O(n log n)
* Best: O(n log n)
* In place: No
* Stable: Yes
* Remarks: n log n guarantee
*
* O(n log n) guarantee
* Compares? Merge sort IS OPTIMAL with respect to number of compares.
* Space? Merge sort IS NOT OPTIMAL with respect to space usage.
*/
class MergeSortKotlin {

    private var beginTime = 0L
    private val selectionSort = SelectionSort()

    fun merge(mainArray: Array<Int>) {
        println("MERGE SORT INPUT DATA: ${mainArray.contentToString()}")
        beginTime = System.currentTimeMillis()

        sort(mainArray, 0, mainArray.size)
    }

    private fun sort(mainArray: Array<Int>, start: Int, end: Int) {
        if (start >= end) return

        val mid = (start + end) / 2

        // Not recursive implementation. Only one time sort for each side
        selectionSort.sortIntegersAscending(mainArray, start, mid)
        selectionSort.sortIntegersAscending(mainArray, mid, end)
        merge(mainArray, start, mid, end)
    }

    private fun merge(mainArray: Array<Int>, start: Int, mid: Int, end: Int) {
        val leftArray = mainArray.copyOfRange(start, mid)
        val rightArray = mainArray.copyOfRange(mid, end)

//        println("MERGE SORT LEFT ARRAY SIZE: ${leftArray.size}, results: ${leftArray.contentToString()}")
//        println("MERGE SORT RIGHT ARRAY SIZE: ${rightArray.size}, results:  ${rightArray.contentToString()}")

        var leftArrayIndex = 0
        var rightArrayIndex = 0

        // compare if left-right array value and set smaller one to main array
        for (k in start until end) {
            when {
                rightArrayIndex >= rightArray.size -> {
                    mainArray[k] = leftArray[leftArrayIndex]
                    leftArrayIndex++
                }
                leftArrayIndex < leftArray.size && leftArray[leftArrayIndex] <= rightArray[rightArrayIndex] -> {
                    mainArray[k] = leftArray[leftArrayIndex]
                    leftArrayIndex++
                }
                else -> {
                    mainArray[k] = rightArray[rightArrayIndex]
                    rightArrayIndex++
                }
            }
        }

        println("MERGE SORT TIME: ${System.currentTimeMillis() - beginTime}, result: ${mainArray.contentToString()}")
    }

}
