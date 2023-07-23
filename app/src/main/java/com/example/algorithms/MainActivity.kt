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
import com.example.algorithms.dataStructures.hash.HashMapExample
import com.example.algorithms.dataStructures.linkedList.LinkedList
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

//        Trees
//        val tree = makeTree()
//        tree.forEachLevelOrder { println(it.value) }
//        tree.search("chai tea")
//        tree.printEachLevel()
//
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

//        Linked list
//        linkedListPushAndAppendExample()
//        linkedListInsertExample()
//        linkedListPopExample()
//        linkedListRemoveLastExample()
//        linkedListRemoveAfterExample()
//        linkedListGetMiddleNodeExample()
//        linkedListPrintReversedExample()
//        linkedListAddReversedExample()

//        HashMap
//        HashMapExample().apply {
//            add("Banana")
//            add("Avokado")
//            add("Blueberry")
//            add("Apple")
//            add("Coconut")
//
//            printMap()
//
//            remove("Blueberry")
//
//            printMap()
//        }

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

private fun linkedListAddReversedExample() {
    val list = LinkedList<Int>().apply {
        push(1)
        push(2)
        push(3)
        push(4)
        push(5)
        push(6)
        push(7)
    }

    println("Add nodes normally: $list")

    println("Add nodes reversed: ${list.reversed()}")
}

private fun linkedListPrintReversedExample() {
    val list = LinkedList<Int>().apply {
        push(1)
        push(2)
        push(3)
        push(4)
        push(5)
        push(6)
        push(7)
    }

    println(list)

    // run in main() function to see results because of `print()` usage
    list.nodeAt(0)?.printInReverse()
}

private fun linkedListGetMiddleNodeExample() {
    val list = LinkedList<Int>().apply {
        push(1)
        push(2)
        push(3)
        push(4)
        push(5)
        push(6)
        push(7)
    }

    println("Initial list: $list")

    val middleNode = list.getMiddleNode()

    println("Middle node is: ${middleNode?.value}")
}

private fun linkedListRemoveAfterExample() {
    val list = LinkedList<Int>().apply {
        push(3)
        push(2)
        push(1)
    }

    println("List before removing last node: $list")

    list.nodeAt(0)?.let { node ->
        list.removeAfter(node)
    }

    println("List after removing last node: $list")
}

private fun linkedListRemoveLastExample() {
    val list = LinkedList<Int>().apply {
        push(3)
        push(2)
        push(1)
    }

    println("List before removing last node: $list")
    list.removeLast()
    println("List after removing last node: $list")
}

private fun linkedListPopExample() {
    val list = LinkedList<Int>()

    list.apply {
        push(3)
        push(2)
        push(1)
    }

    println("List before popping: $list")

    list.pop()

    println("List after popping: $list")

}

private fun linkedListPushAndAppendExample() {
    val list1 = LinkedList<Int>().apply {
        push(1)
        push(2)
        push(3)
    }
    println(list1)

    val list2 = LinkedList<Int>().apply {
        append(1)
        append(2)
        append(3)
    }

    println(list2)
}

private fun linkedListInsertExample() {
    val list = LinkedList<Int>().apply {
        push(3)
        push(2)
        push(1)
    }

    println("Before inserting: $list")

    list.nodeAt(1)?.let { node ->
        list.insert(value = 777, afterNode = node)
    }
    println("After inserting: $list")
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
