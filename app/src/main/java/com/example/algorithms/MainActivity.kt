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
import com.example.algorithms.binarySearch.BinarySearch
import com.example.algorithms.tasks.TreePrinter
import com.example.algorithms.ui.theme.AlgorithmsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        taskOne()

//        TimeComplexity().checkOLogN()

        BinarySearch().search(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 2)

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