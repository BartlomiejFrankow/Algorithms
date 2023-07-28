package com.example.algorithms.dataStructures.linkedList

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

fun main() {
    linkedListPushAndAppendExample()
    linkedListInsertExample()
    linkedListPopExample()
    linkedListRemoveLastExample()
    linkedListRemoveAfterExample()
    linkedListGetMiddleNodeExample()
    linkedListPrintReversedExample()
    linkedListAddReversedExample()
}
