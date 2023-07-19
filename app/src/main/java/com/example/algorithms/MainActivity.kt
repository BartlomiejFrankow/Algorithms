package com.example.algorithms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.algorithms.dataStructures.queue.newexample.Queue
import com.example.algorithms.dataStructures.queue.newexample.QueueImpl
import com.example.algorithms.ui.theme.AlgorithmsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        taskOne()

//        TimeComplexity().checkOLogN()

//        BinarySearch().search(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 10)

//        val times = 10
//        val randomIntegers = Array(100 * times) { Random().nextInt(1000 * times) }
//        val insertSortRandomCopy = randomIntegers.copyOf()
//        val shellSortRandomCopy = randomIntegers.copyOf()
//        val mergeSortJavaRandomCopy = randomIntegers.copyOf()
//        val mergeSortRandomCopy = randomIntegers.copyOf()
//        val quickSortRandomArrayCopy = randomIntegers.copyOf()
//        val threeWayQuickSortRandomArrayCopy = randomIntegers.copyOf()
//        val heapSortRandomArrayCopy = randomIntegers.copyOf()
//
//        SelectionSort().sortIntegersAscending(randomIntegers, 0, randomIntegers.size)
//        InsertionSort().sortIntegersAscending(insertSortRandomCopy)
//        ShellSortKotlin().sortIntegersAscending(shellSortRandomCopy)
//        MergeSortJava.sort(mergeSortJavaRandomCopy)
//        MergeSortKotlin().merge(mergeSortRandomCopy)
//        QuickSort().sort(quickSortRandomArrayCopy)
//        ThreeWayQuickSort().sort(threeWayQuickSortRandomArrayCopy)
//
//        Shuffle().randomize(randomIntegers)
//        heapSortRandomArrayCopy.heapSort(ascending)

//        val traversal = Traversal()
//        val root = traversal.createTreeAndGetRoot()
//
//        traversal.preorder(root)
//        traversal.inorder(root)
//        traversal.postorder(root)

//        Stacks
//        println("((())))".isValidParentheses())

//        Queue
//        queueExample()

        setContent {
            AlgorithmsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

fun main() {
}

private fun queueExample() {
    QueueImpl<Int>().apply {
        enqueue(1)
        println("Add element 1")
        enqueue(2)
        println("Add element 2")
        enqueue(3)
        println("Add element 3")

        // results should be FIFO: 1, 2, 3
        println("Peek elements one by one: ${this.peek()}, ${this.peek()}, ${this.peek()}")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AlgorithmsTheme {
        Greeting("Android")
    }
}
