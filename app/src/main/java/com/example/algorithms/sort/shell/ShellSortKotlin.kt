package com.example.algorithms.sort.shell

import com.example.algorithms.help.StdOut
import com.example.algorithms.sort.exchange
import kotlin.system.measureTimeMillis

/*Time complexity:
* Worst: ?
* Average: ?
* Best: O(n)
* In place: Yes
* Stable: No
* Remarks: will work fast for intermediate size n file with not much code
*/

private const val STEPS = 3 // steps could be modified

class ShellSortKotlin {

    fun sortIntegersAscending(array: Array<Int>) {
        StdOut.println("SHELL SORT KOTLIN INPUT DATA: " + array.contentToString())

        val measuredTime = measureTimeMillis {
            var sequence = 1

            while (sequence < array.size / STEPS) {
                sequence = STEPS * sequence + 1 // 1, 4, 13, 40, 121, 364... depends on step value
            }

            while (sequence >= 1) {
                for (i in sequence until array.size) {
                    var j = i
                    while (j >= sequence && array[j] < array[j - sequence]) {
                        exchange(array, j, j - sequence)
                        j -= sequence
                    }
                }
                sequence /= STEPS
            }
        }

        StdOut.println("SHELL SORT KOTLIN TIME: $measuredTime ms, results: " + array.contentToString())
    }
}
