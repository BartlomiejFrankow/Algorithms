package com.example.algorithms.dataStructures.tree.traversal

// Time complexity: O(n)
class Traversal {

    private val results: ArrayList<String> = arrayListOf()

    /*      Node tree
    *            A
    *          *  *
    *        B     C
    *      *  *
    *     D    E
    *         *
    *        F
    * */

    fun createTreeAndGetRoot(): Node {
        val a = Node("A")
        val b = Node("B")
        val c = Node("C")
        val d = Node("D")
        val e = Node("E")
        val f = Node("F")

        a.rightChild = c
        a.leftChild = b
        b.leftChild = d
        b.rightChild = e
        e.leftChild = f

        return a // root
    }

    /* PREORDER
    Steps:
    1. Set “A” as checked
    2. Go to left subtree -> “B” vertex and select as checked
    3. Go to left subtree -> “D” vertex and select as checked
    4. Go to left subtree -> null
    5. Go to right subtree -> null
    6. Return back -> “B” vertex
    7. Left subtree was checked so go to right subtree -> “E” vertex and select as checked
    8. Go to left subtree -> “F” vertex and select as checked
    9. Go to left subtree -> null
    10. Go to right subtree -> null
    11. Return back -> “E” vertex
    12. Return back -> “B” vertex
    13. Return back -> “A” vertex
    14. Left subtree was checked so go to right subtree -> “C” vertex and select as checked
    15. Go to left subtree -> null
    16. Go to right subtree -> null
    17. Finish

    Path: A -> B -> D -> E -> F -> C
    */
    fun preorder(root: Node?) {
        if (root == null) return

        addPreorderValues(root)

        println("TRAVERSAL_PREORDER_RESULTS: $results")

        results.clear()
    }

    private fun addPreorderValues(node: Node) {
        results.add(node.data)

        node.leftChild?.let { addPreorderValues(it) }

        node.rightChild?.let { addPreorderValues(it) }
    }

    /* INORDER
    Steps:
    1. Go to left subtree -> “B”
    2. Go to left subtree -> “D”
    3. Go to left subtree -> null
    4. Set “D” as checked
    5. Go to right subtree -> null
    6. Return back -> “B” vertex and left subtree was checked so now it’s time to set “B” as checked
    7. Set “B” as checked
    8. Go to right subtree -> “E”
    9. Go to left subtree -> “F”
    10. Go to left subtree -> null
    11. Set “F” as checked
    12. Go to right subtree -> null
    13. Return back -> “E” vertex and left subtree was checked so now it’s time to set “E” as checked
    14. Set “E” as checked
    15. Go to right subtree -> null
    16. Return back -> “B” both right/left vertex was checked so now it’s time to go back
    17. Return back -> “A” vertex and left subtree was checked so now it’s time to set “A” as checked
    18. Set “A” as checked
    19. Go to right subtree -> “C”
    20. Go to left subtree -> null
    21. Set “C” as checked
    22. Go to right subtree -> null
    23. Finish

    Path: D -> B -> F -> E -> A -> C
    */
    fun inorder(root: Node?) {
        if (root == null) return

        addInorderValues(root)

        println("TRAVERSAL_INORDER_RESULTS: $results")

        results.clear()
    }

    private fun addInorderValues(node: Node) {
        node.leftChild?.let { addInorderValues(it) }

        results.add(node.data)

        node.rightChild?.let { addInorderValues(it) }
    }

    /* POSTORDER
    Steps:
    1. Go to left subtree -> “B”
    2. Go to left subtree -> “D”
    3. Go to left subtree -> null
    4. Go to right subtree -> null
    5. Set “D” as checked
    6. Return back -> “B” vertex and left subtree was checked so now it’s time do right subtree check
    7. Go to right subtree -> “E”
    8. Go to left subtree -> “F”
    9. Go to left subtree -> null
    10. Go to right subtree -> null
    11. Set “F” as checked
    12. Return back -> “E” vertex and left subtree was checked so now it’s time do right subtree check
    13. Go to right subtree -> null
    14. Set “E” as checked
    15. Return back -> “B” vertex and left/right subtree was checked so now it’s time to set “B” as checked
    16. Set “B” as checked
    17. Return back -> “A” vertex and left subtree was checked so now it’s time do right subtree check
    18. Go to right subtree -> “C”
    19. Go to left subtree -> null
    20. Go to right subtree -> null
    21. Set “C” as checked
    22. Return back -> “A” vertex and left/right subtree was checked so now it’s time to set “A” as checked
    23. Set “A” as checked
    24. Finish

    Path: D -> F -> E -> B -> C -> A
    */
    fun postorder(root: Node?) {
        if (root == null) return

        addPostorderValues(root)

        println("TRAVERSAL_POSTORDER_RESULTS: $results")

        results.clear()
    }

    private fun addPostorderValues(node: Node) {
        node.leftChild?.let { addPostorderValues(it) }

        node.rightChild?.let { addPostorderValues(it) }

        results.add(node.data)
    }

}

class Node(var data: String) {
    var leftChild: Node? = null
    var rightChild: Node? = null
}

fun main() {
    val traversal = Traversal()
    val root = traversal.createTreeAndGetRoot()

    traversal.preorder(root)
    traversal.inorder(root)
    traversal.postorder(root)
}
