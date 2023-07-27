package com.example.algorithms.dataStructures.graph.undirected

import com.example.algorithms.dataStructures.queue.newexample.QueueImpl
import com.example.algorithms.dataStructures.stacks.kotlin.newexample.StackImpl

/**
 * Time complexity: O(V + E) // V - vertices, E - traversed edges
 * Space complexity: O(V)
 *
 * Nice introduction to graphs: https://www.youtube.com/watch?v=TIbUeeksXcI&t=21s&ab_channel=BackToBackSWE
 * */
class UndirectedGraph<T> {

    val adjacencyMap: HashMap<T, HashSet<T>> = HashMap()

    fun addEdge(sourceVertex: T, destinationVertex: T) {
        adjacencyMap
            .computeIfAbsent(sourceVertex) { HashSet() }
            .add(destinationVertex)

        adjacencyMap
            .computeIfAbsent(destinationVertex) { HashSet() }
            .add(sourceVertex)
    }

    /**
     * LIFO with Stack
     * Usages: Backtracking complete, search, exhausting possible paths
     * */
    fun depthFirstTraversal(startNode: T): HashSet<T> {
        val stack = StackImpl<T>()
        val seen = hashSetOf<T>()
        val results = hashSetOf<T>()

        stack.push(startNode)

        while (!stack.isEmpty) {
            stack.pop()?.let { currentNode ->
                if (!seen.contains(currentNode)) {
                    seen.add(currentNode)
                    results.add(currentNode)
                }

                this.adjacencyMap[currentNode]?.forEach { adjacent ->
                    if (!seen.contains(adjacent)) {
                        stack.push(adjacent)
                    }
                }
            }
        }

        return results
    }

    /**
     * FIFO with Queue
     * Usages: If a path exist between nodes,
     * finding "hops" or distance out or "levels" away
     * */
    fun breadthFirstTraversal(startNode: T): HashSet<T> {
        val queue = QueueImpl<T>()
        val seen = hashSetOf<T>()
        val results = hashSetOf<T>()

        queue.enqueue(startNode)

        while (!queue.isEmpty) {
            queue.dequeue()?.let { currentNode ->
                if (!seen.contains(currentNode)) {
                    seen.add(currentNode)
                    results.add(currentNode)
                    // results of search
                }

                this.adjacencyMap[currentNode]?.forEach { adjacent ->
                    if (!seen.contains(adjacent)) {
                        queue.enqueue(adjacent)
                    }
                }
            }
        }

        return results
    }
}

fun main() {
    val graph = UndirectedGraph<String>().apply {
        addEdge("A", "B")
        addEdge("A", "C")
        addEdge("A", "D")
        addEdge("A", "E")
        addEdge("E", "F")
        addEdge("F", "H")
        addEdge("F", "G")
        addEdge("B", "G")
        addEdge("B", "C")
        addEdge("D", "C")
        addEdge("D", "E")
        addEdge("H", "D")
    }

    val dftResults = graph.depthFirstTraversal("A")
    println("Depth first: $dftResults")

    val bftResults = graph.breadthFirstTraversal("A")
    println("Breadth first: $bftResults")
}
