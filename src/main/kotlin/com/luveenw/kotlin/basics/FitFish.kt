package com.luveenw.kotlin.basics

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 0, hasDecorations: Boolean = true): Boolean {
    val effectiveSize = if (hasDecorations) tankSize * 0.8 else tankSize

    return currentFish.sum() + fishSize <= effectiveSize
}

fun main(args: Array<String>) {
    println(canAddFish(10.0, listOf(3,3,3))) // false
    println(canAddFish(8.0, listOf(2,2,2), hasDecorations = false)) // true
    println(canAddFish(9.0, listOf(1,1,3), 3))// false
    println(canAddFish(10.0, listOf(), 7, true)) // true
}