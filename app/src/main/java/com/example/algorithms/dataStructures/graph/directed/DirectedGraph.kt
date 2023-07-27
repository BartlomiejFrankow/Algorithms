package com.example.algorithms.dataStructures.graph.directed

// https://medium.com/@arilsonjr/directed-graph-with-kotlin-292913911529

data class Vertex<T>(val index: Int, val data: T)

data class Edge<T>(val source: Vertex<T>, val destination: Vertex<T>, val weight: Double? = null)

class DirectedGraph<T> {

    private val adjacencyMap = mutableMapOf<Vertex<T>, ArrayList<Edge<T>>>()

    fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencyMap.count(), data)
        adjacencyMap[vertex] = arrayListOf()
        return vertex
    }

    fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double? = 0.0) {
        val edge = Edge(source, destination, weight)
        adjacencyMap[source]?.add(edge)
    }

    override fun toString(): String {
        return buildString {
            adjacencyMap.forEach { (vertex, edges) ->
                val edgeString = edges.joinToString { it.destination.data.toString() }
                append("${vertex.data} -> [$edgeString]\n")
            }
        }
    }
}

fun main() {
    val adjacencyListGraph = DirectedGraph<String>()

    val brazil = adjacencyListGraph.createVertex("Brazil")
    val germany = adjacencyListGraph.createVertex("Germany")
    val thailand = adjacencyListGraph.createVertex("Thailand")
    val unitedKingdom = adjacencyListGraph.createVertex("United Kingdom")

    adjacencyListGraph.addDirectedEdge(brazil, germany, 1860.00)
    adjacencyListGraph.addDirectedEdge(brazil, thailand, 2310.00)
    adjacencyListGraph.addDirectedEdge(thailand, germany, 1250.00)
    adjacencyListGraph.addDirectedEdge(germany, unitedKingdom, 1310.00)
    adjacencyListGraph.addDirectedEdge(unitedKingdom, brazil, 890.00)

    println(adjacencyListGraph)
}
