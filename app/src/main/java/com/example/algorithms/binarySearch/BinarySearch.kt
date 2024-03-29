package com.example.algorithms.binarySearch

/**
 * Time complexity is: O(1) + lg N In binary search, the number of array accesses equal
 * the number of compares, which we have seen is "~1lgn"
 * e.g., when the key we are searching for is not in the array.
 *
 * Input data need to be sorted ascending before search.
 */
class BinarySearch {

    fun search(array: IntArray, searchGoal: Int): Int {
        var left = 0
        var right = array.size - 1

        // when the value is higher or lower than highest or lowest value in the array there is no need to search
        if (searchGoal > array[right] || searchGoal < array[left]) return -1

        while (left <= right) {
            val middle = left + (right - left) / 2

            when {
                searchGoal < array[middle] -> right = middle - 1
                searchGoal > array[middle] -> left = middle + 1
                else -> return array[middle].also { success(array[middle], middle) }
            }
        }

        return -1
    }

    private fun recursiveSearch(array: IntArray, searchGoal: Int, left: Int, right: Int): Int {
        if (left > right) {
            fail()
            return -1
        }

        val middle = left + ((right - left) / 2)

        return when {
            searchGoal < array[middle] -> recursiveSearch(array, searchGoal, left, middle - 1)
            searchGoal > array[middle] -> recursiveSearch(array, searchGoal, middle + 1, right)
            else -> array[middle].also { success(array[middle], middle) }
        }
    }

    fun recursiveSearch(array: IntArray, searchGoal: Int): Int {
        // when the value is higher or lower than highest or lowest value in the array there is no need to search
        if (searchGoal > array[array.size - 1] || searchGoal < array[0]) return -1

        return recursiveSearch(array, searchGoal, 0, array.size - 1)
    }


    private fun fail() {
        println("Binary search: goal not found")
    }

    private fun success(value: Int, index: Int) {
        println("binary search: goal found and it is $value (taken from index: $index)")
    }
}

fun main() {
    val binarySearch = BinarySearch()

    print("Iterative ")
    binarySearch.search(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 12)
    print("Recursive ")
    binarySearch.recursiveSearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 12)
}
