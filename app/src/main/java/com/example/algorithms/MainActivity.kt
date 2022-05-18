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
import com.example.algorithms.sort.insertion.InsertionSort
import com.example.algorithms.sort.merge.MergeSort
import com.example.algorithms.sort.quick.QuickSort
import com.example.algorithms.sort.selection.SelectionSort
import com.example.algorithms.sort.shell.ShellSortKotlin
import com.example.algorithms.sort.shuffle.Shuffle
import com.example.algorithms.tasks.TreePrinter
import com.example.algorithms.ui.theme.AlgorithmsTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        taskOne()

//        TimeComplexity().checkOLogN()

//        BinarySearch().search(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 2)

//        val times = 1
//        val randomIntegers = Array(100 * times) { Random().nextInt(1000 * times) }
//        val insertSortRandomCopy = randomIntegers.copyOf()
//        val shellSortRandomCopy = randomIntegers.copyOf()
//        val mergeSortRandomCopy = randomIntegers.copyOf()
//        val quickSortRandomArrayCopy = randomIntegers.copyOf()
//
//        SelectionSort().sortIntegersAscending(randomIntegers, 0, randomIntegers.size)
//        InsertionSort().sortIntegersAscending(insertSortRandomCopy)
//        ShellSortKotlin().sortIntegersAscending(shellSortRandomCopy)
//        MergeSort().merge(mergeSortRandomCopy)
//        QuickSort().sort(quickSortRandomArrayCopy)
//
//        Shuffle().randomize(randomIntegers)

        setContent {
            AlgorithmsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

private fun taskOne() {
    val inputList = mutableListOf<Relation>()

    inputList.add(Relation("animal", "mammal"))
    inputList.add(Relation("animal", "bird"))
    inputList.add(Relation("lifeform", "animal"))
    inputList.add(Relation("cat", "lion"))
    inputList.add(Relation("mammal", "cat"))
    inputList.add(Relation("animal", "fish"))

    TreePrinter().printTree(inputList)
}

data class Relation(val parent: String, val child: String)

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
