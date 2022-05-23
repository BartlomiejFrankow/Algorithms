package com.example.algorithms.sort.heap

import com.example.algorithms.sort.exchange
import kotlin.system.measureTimeMillis

fun <T> Array<T>.heapSort(comparator: Comparator<T>) {
    println("HEAP SORT INPUT DATA: ${this.contentToString()}")

    val measureTime = measureTimeMillis {
        this.heapify(comparator)

        for (index in this.indices.reversed()) {
            exchange(this, 0, index)
            siftDown(0, index, comparator)
        }
    }

    println("HEAP SORT TIME: $measureTime, result: ${this.contentToString()}")
}

private fun leftChildIndex(index: Int) = (2 * index)

private fun rightChildIndex(index: Int) = (2 * index) + 1

private fun <T> Array<T>.siftDown(index: Int, upTo: Int, comparator: Comparator<T>) {
    var parent = index

    while (true) {
        val left = leftChildIndex(parent)
        val right = rightChildIndex(parent)
        var candidate = parent

        if (left < upTo && comparator.compare(this[left], this[candidate]) > 0) {
            candidate = left
        }
        if (right < upTo && comparator.compare(this[right], this[candidate]) > 0) {
            candidate = right
        }
        if (candidate == parent) {
            return
        }

        exchange(this, parent, candidate)
        parent = candidate
    }
}

private fun <T> Array<T>.heapify(comparator: Comparator<T>) {
    if (this.isNotEmpty()) {
        (this.size / 2 downTo 0).forEach {
            this.siftDown(it, this.size, comparator)
        }
    }
}

val descending = Comparator { first: Int, second: Int ->
    when {
        first < second -> 1
        first > second -> -1
        else -> 0
    }
}

val ascending = Comparator { first: Int, second: Int ->
    when {
        first > second -> 1
        first < second -> -1
        else -> 0
    }
}
