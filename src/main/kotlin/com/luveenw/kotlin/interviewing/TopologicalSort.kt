package com.luveenw.kotlin.interviewing

import java.util.*
import java.util.stream.Collectors

fun topologicalSort(graph: Graph): List<Node> {
    val stack = ArrayDeque<Node>()
    val visited = HashSet<Node>()

    graph.nodes.forEach { node ->
        if (!visited.contains(node)) {
            sortHelper(node, graph, stack, visited)
        }
    }

    return stack.toList()
}

fun sortHelper(node: Node, graph: Graph, stack: ArrayDeque<Node>, visited: HashSet<Node>) {
    visited.add(node)

    graph.neighborsOf(node).forEach { neighbor ->
        if (!visited.contains(neighbor)) {
            sortHelper(neighbor, graph, stack, visited)
        }
    }

    stack.addFirst(node)
}

fun main(args: Array<String>) {
    val a = Node("a")
    val b = Node("b")
    val c = Node("c")
    val d = Node("d")
    val e = Node("e")
    val f = Node("f")
    val g = Node("g")
    val graph = Graph()

    graph.addEdge(a, c)
    graph.addEdge(b, c)
    graph.addEdge(b, e)
    graph.addEdge(c, d)
    graph.addEdge(d, f)
    graph.addEdge(e, f)
    graph.addEdge(f, g)

    println(topologicalSort(graph).stream()
            .map(Node::toString)
            .collect(Collectors.joining(", ")))
}