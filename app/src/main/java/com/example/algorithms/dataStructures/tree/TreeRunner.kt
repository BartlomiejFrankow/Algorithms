package com.example.algorithms.dataStructures.tree

fun makeTree(): TreeNode<String> {
    val tree = TreeNode("Drinks")

    val hot = TreeNode("hot")
    val cold = TreeNode("cold")

    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("chocolate")

    val blackTea = TreeNode("black tea")
    val greenTea = TreeNode("green tea")
    val chaiTea = TreeNode("chai tea")

    val soda = TreeNode("soda")
    val milk = TreeNode("milk")

    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")

    // 1st level
    tree.add(hot)
    tree.add(cold)

    // 2nd level
    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)

    cold.add(soda)
    cold.add(milk)

    // 3rd level
    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)

    soda.add(gingerAle)
    soda.add(bitterLemon)

    return tree
}

fun main() {
    val tree = makeTree()
    tree.forEachLevelOrder { println(it.value) }
    tree.search("chai tea")
    tree.printEachLevel()
}
