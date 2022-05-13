package com.example.algorithms.binarySearch

class BinarySearch {

    // Time complexity is: 1 + lg N
    // In binary search, the number of array accesses equal the number of compares, which we have seen is "~1lgn"
    // e.g., when the key we are searching for is not in the array.
    fun search(integersArray: IntArray, searchGoal: Int): Int {
        var low = 0
        var high = integersArray.size

        while (low <= high) {
            val middle = low + (high - low) / 2

            when {
                searchGoal < integersArray[middle] -> high = middle - 1
                searchGoal > integersArray[middle] -> low = middle + 1
                else -> return integersArray[middle].also {
                    println("Binary search: goal found and it is ${integersArray[middle]}")
                }
            }
        }

        println("Binary search: goal not found")
        return -1
    }

}
