package com.example.algorithms.sort

fun exchange(array: Array<Int>, indexToBeSwap: Int, swapIndex: Int) {
    val swap = array[indexToBeSwap]

    array[indexToBeSwap] = array[swapIndex]
    array[swapIndex] = swap
}
