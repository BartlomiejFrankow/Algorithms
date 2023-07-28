package com.example.algorithms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.algorithms.sort.heap.ascending
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
    val times = 10
    val randomIntegers = Array(100 * times) { Random().nextInt(1000 * times) }
    val insertSortRandomCopy = randomIntegers.copyOf()
    val shellSortRandomCopy = randomIntegers.copyOf()
    val mergeSortJavaRandomCopy = randomIntegers.copyOf()
    val mergeSortRandomCopy = randomIntegers.copyOf()
    val quickSortRandomArrayCopy = randomIntegers.copyOf()
    val threeWayQuickSortRandomArrayCopy = randomIntegers.copyOf()
    val heapSortRandomArrayCopy = randomIntegers.copyOf()

    // Don't run all of algorithms at once - too many data and logs are not readable ;)
//    SelectionSort().sortIntegersAscending(randomIntegers, 0, randomIntegers.size)
//    InsertionSort().sortIntegersAscending(insertSortRandomCopy)
//    ShellSortKotlin().sortIntegersAscending(shellSortRandomCopy)
//    MergeSortJava.sort(mergeSortJavaRandomCopy)
//    MergeSortKotlin().merge(mergeSortRandomCopy)
//    QuickSort().sort(quickSortRandomArrayCopy)
//    ThreeWayQuickSort().sort(threeWayQuickSortRandomArrayCopy)
//    Shuffle().randomize(randomIntegers)
//    heapSortRandomArrayCopy.heapSort(ascending)
}
