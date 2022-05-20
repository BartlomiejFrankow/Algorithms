package com.example.algorithms.sort.quick

import com.example.algorithms.sort.SortHelperJava.compareTo
import com.example.algorithms.sort.exchange
import com.example.algorithms.sort.shuffle.Shuffle

/*Time complexity:
* Worst: O(n^2/2) - shuffling eliminates worst case
* Average: O(2n log n)
* Best: O(n log n)
* In place: Yes
* Stable: No
* Remarks: improves quick sort in presence of duplicate key -> n log n probabilistic guarantee fastest in practice!
*/
class ThreeWayQuickSort {
    private var beginTime = 0L

    fun sort(mainArray: Array<Int>) {
        println("THREE WAY QUICK SORT INPUT DATA: ${mainArray.contentToString()}")
        beginTime = System.currentTimeMillis()

        Shuffle().randomize(mainArray) // Shuffling is needed for performance guarantee

        sort(mainArray, 0, mainArray.size - 1)
    }

    private fun sort(mainArray: Array<Int>, low: Int, high: Int) {
        if (high <= low) return

        var lt = low
        var gt = high
        var i = low
        val value = mainArray[low]

        while (i <= gt) {
            val compare = compareTo(mainArray[i], value)

            if (compare < 0) {
                exchange(mainArray, lt++, i++)
            } else if (compare > 0) {
                exchange(mainArray, i, gt--)
            } else {
                i++
            }
        }

        sort(mainArray, low, lt - 1)
        sort(mainArray, gt + 1, high)

        println("THREE WAY QUICK SORT TIME: ${System.currentTimeMillis() - beginTime}, result: ${mainArray.contentToString()}")
    }

}
