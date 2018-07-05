package com.luveenw.kotlin.basics

fun <T> toJSON(collection: Collection<T>): String {
    val sb = StringBuilder()
    sb.append("[")
    val iterator = collection.iterator()
    while (iterator.hasNext()) {
        val element = iterator.next()
        sb.append(element)
        if (iterator.hasNext()) {
            sb.append(", ")
        }
    }
    sb.append("]")
    return sb.toString()
}

fun main(args: Array<String>) {
    println(toJSON(listOf(1, 2, 3, 4, 5)))
    println(toJSON(listOf("a", "b", "c")))
}