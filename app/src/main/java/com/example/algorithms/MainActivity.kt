package com.example.algorithms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.algorithms.sort.heap.ascending
import com.example.algorithms.sort.heap.descending
import com.example.algorithms.sort.heap.heapSort
import com.example.algorithms.sort.insertion.InsertionSort
import com.example.algorithms.sort.merge.java.MergeSortJava
import com.example.algorithms.sort.merge.kotlin.MergeSortKotlin
import com.example.algorithms.sort.quick.QuickSort
import com.example.algorithms.sort.quick.ThreeWayQuickSort
import com.example.algorithms.sort.selection.SelectionSort
import com.example.algorithms.sort.shell.ShellSortKotlin
import com.example.algorithms.sort.shuffle.Shuffle
import com.example.algorithms.ui.theme.AlgorithmsTheme
import java.util.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlgorithmsTheme {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Hello Algorithms and Data Structures!",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

fun main() {
    // Algorithms examples
    val randomIntegers = Array(10_000) { Random().nextInt(100_000_000) }
    val insertSortRandomCopy = randomIntegers.copyOf()
    val shellSortRandomCopy = randomIntegers.copyOf()
    val mergeSortJavaRandomCopy = randomIntegers.copyOf()
    val mergeSortRandomCopy = randomIntegers.copyOf()
    val quickSortRandomArrayCopy = randomIntegers.copyOf()
    val threeWayQuickSortRandomArrayCopy = randomIntegers.copyOf()
    val heapSortRandomArrayCopy = randomIntegers.copyOf()

    /**
     * Don't run all of algorithms at once - too many data and logs are not readable.
     * Tests results in right side comments next to it was made on 10_000 integer array.
     *
     * Shell sort is very quick, but heap sort is faster when input data is very large.
     * For example in case of 10_000_000 random integers:
     * Shell sort time: 14_030 ms
     * Heap sort time: 12_248 ms
     *
     * But in lower input data like 10_000 random integers:
     * Shell sort time: 6 ms
     * Heap sort time: 16 ms
     * */
//    SelectionSort().sortIntegersAscending(randomIntegers, 0, randomIntegers.size) // 52 milliseconds
//    InsertionSort().sortIntegersAscending(insertSortRandomCopy) // 71 milliseconds
//    ShellSortKotlin().sortIntegersAscending(shellSortRandomCopy) // 6 milliseconds
//    MergeSortJava.sort(mergeSortJavaRandomCopy) // 3476 milliseconds
//    MergeSortKotlin().merge(mergeSortRandomCopy) // 47 milliseconds
//    QuickSort().sort(quickSortRandomArrayCopy) // 1984 milliseconds
//    ThreeWayQuickSort().sort(threeWayQuickSortRandomArrayCopy) // 1923 milliseconds
//    Shuffle().randomize(randomIntegers) // 2ms
//    heapSortRandomArrayCopy.heapSort(ascending) // 16ms
}
