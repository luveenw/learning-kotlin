package com.luveenw.kotlin.basics

val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")
val curriesByLength = spices.asSequence().filter { it.contains("curry") }.sortedBy { it.length }
val startCEndE = spices.asSequence().filter { it.startsWith('c') && it.endsWith('e') }
val firstThreeStartC = spices.asSequence().filterIndexed{ i, it -> i < 3 }.filter { it.startsWith('c') }

fun main(args: Array<String>) {
    println(curriesByLength.toList())
    println(startCEndE.toList())
    println(firstThreeStartC.toList())
}
