package com.example.algorithms.dijkstra

import com.example.algorithms.help.Graph

fun <T> dijkstra(graph: Graph<T>, start: T): Map<T, T?> {
    val verticesSubset: MutableSet<T> = mutableSetOf()

    val delta = graph.vertices.associateWith { Int.MAX_VALUE }.toMutableMap()
    delta[start] = 0

    val previous: MutableMap<T, T?> = graph.vertices.associateWith { null }.toMutableMap()

    while (verticesSubset != graph.vertices) {
        val v: T = delta
            .filter { !verticesSubset.contains(it.key) }
            .minByOrNull { it.value }!!
            .key

        graph.edges.getValue(v).minus(verticesSubset).forEach { neighbor ->
            val newPath = delta.getValue(v) + graph.weights.getValue(Pair(v, neighbor))

            if (newPath < delta.getValue(neighbor)) {
                delta[neighbor] = newPath
                previous[neighbor] = v
            }
        }

        verticesSubset.add(v)
    }

    return previous.toMap()
}

fun <T> shortestPath(shortestPathTree: Map<T, T?>, start: T, end: T): List<T> {
    fun pathTo(start: T, end: T): List<T> {
        if (shortestPathTree[end] == null) return listOf(end)
        return listOf(pathTo(start, shortestPathTree[end]!!), listOf(end)).flatten()
    }

    return pathTo(start, end)
}

