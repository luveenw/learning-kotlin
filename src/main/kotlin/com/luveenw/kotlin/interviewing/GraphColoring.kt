package com.luveenw.kotlin.interviewing

import com.google.common.collect.ListMultimap
import com.google.common.collect.MultimapBuilder.ListMultimapBuilder
import com.google.common.collect.Sets
import java.util.*
import java.util.stream.Collectors

fun main(args: Array<String>) {
    val a = Node("a")
    val b = Node("b")
    val c = Node("c")
    val d = Node("d")
    val graph = Graph()

    graph.addEdge(a, b)
    graph.addEdge(a, c)
    graph.addEdge(b, a)
    graph.addEdge(b, c)
    graph.addEdge(b, d)
    graph.addEdge(c, a)
    graph.addEdge(c, b)
    graph.addEdge(d, b)

    colorGraph(graph)
    graph.print()
}

fun colorGraph(g: Graph) {
    var node = g.nodes.iterator().next()  // start at any node
    val queue = ArrayDeque<Node>()
    val visited = HashSet<Node>()

    queue.addLast(node)

    while (queue.isNotEmpty()) {
        node = queue.removeFirst()
        visited.add(node)

        val neighbors = g.neighborsOf(node)
        colorNode(node, neighbors)
        neighbors.forEach {
            if (!visited.contains(it)) {
                queue.addLast(it)
            }
        }
    }
}

private fun colorNode(node: Node, neighbors: List<Node>) {
    val neighborColors = neighbors.map(Node::color).toHashSet()
    val unassignedColors = Sets.difference(Color.values().toSet(), neighborColors)

    check(unassignedColors.isNotEmpty())
    node.color = unassignedColors.iterator().next()
}

data class Graph (val adjacencyMap: ListMultimap<Node, Node>) {
    constructor() : this(ListMultimapBuilder.hashKeys().arrayListValues().build<Node, Node>())

    val nodes: Set<Node>
        get() = this.adjacencyMap.keySet()

    fun addEdge(a: Node, b: Node) {
        this.adjacencyMap.put(a, b)
    }

    fun neighborsOf(n: Node): List<Node> = this.adjacencyMap.get(n)

    fun print() {
        this.nodes.forEach {
            val neighbors = this.neighborsOf(it)
                    .stream()
                    .map(Node::toString)
                    .collect(Collectors.joining(", "))

            println("$it -> $neighbors")
        }
    }
}

data class Node (val label: String, var color: Color? = null) {
    override fun toString(): String  = "$label ($color)"
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val that = other as Node?

        return this.label == that!!.label
    }

    override fun hashCode(): Int {
        return this.label.hashCode()
    }
}

enum class Color {
    RED,
    GREEN,
    BLUE,
    YELLOW
}
