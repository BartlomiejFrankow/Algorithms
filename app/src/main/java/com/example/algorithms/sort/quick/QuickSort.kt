package com.example.algorithms.sort.quick

import com.example.algorithms.sort.exchange
import com.example.algorithms.sort.shuffle.Shuffle

/*Time complexity:
* Worst: O(n^2/2) - shuffling eliminates worst case
* Average: O(2n log n)
* Best: O(n log n)
* In place: Yes
* Stable: No
* Remarks: n log n probabilistic guarantee fastest in practice -> if made improvements to deal with duplicate keys
*/
class QuickSort {

    private var beginTime = 0L

    fun sort(mainArray: Array<Int>) {
        println("QUICK SORT INPUT DATA: ${mainArray.contentToString()}")
        beginTime = System.currentTimeMillis()

        Shuffle().randomize(mainArray) // Shuffling is needed for performance guarantee

        sort(mainArray, 0, mainArray.size - 1)
    }

    private fun sort(mainArray: Array<Int>, low: Int, high: Int) {
        if (high <= low) return

        val partitionMiddleElement = partition(mainArray, low, high)

        sort(mainArray, low, partitionMiddleElement - 1)
        sort(mainArray, partitionMiddleElement + 1, high)

        println("QUICK SORT TIME: ${System.currentTimeMillis() - beginTime} ms, result: ${mainArray.contentToString()}")
    }

    private fun partition(mainArray: Array<Int>, low: Int, high: Int): Int {

        var i = low // at beginning is left side index
        var j = high + 1 // at beginning is right side index + 1 because of later decrementation

        while (true) {
            while (mainArray[++i] < mainArray[low]) // find item on left to swap
                if (i == high) break

            while (mainArray[low] < mainArray[--j]) // find item on right to swap
                if (j == low) break

            if (i >= j) break // check if pointers cross

            exchange(mainArray, i, j) // swap
        }

        exchange(mainArray, low, j) // swap with partitioning element
        return j // return middle element of partition
    }

}
