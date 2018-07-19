package com.luveenw.kotlin.interviewing

import java.lang.Integer.max
import java.util.*

fun largestRectangleInHistogram(a: IntArray): Int {
    val stack = ArrayDeque<Int>()
    var maxArea = Integer.MIN_VALUE
    var area: Int

    a.forEachIndexed { index, it ->
        println("Processing $it at index $index; a[top] is ${if (stack.isNotEmpty()) a[stack.peek()] else null} at index ${stack.peek()}")
        while (stack.isNotEmpty() && a[stack.first] > it) {
            area = calcArea(stack, a, index)
//            println("Comparing current area $area with max area $maxArea...")
            maxArea = max(area, maxArea)
        }

        stack.offerFirst(index)
    }


    while (stack.isNotEmpty()) {
        area = calcArea(stack, a, a.size)
//        println("Comparing current area $area with max area $maxArea...")
        maxArea = max(area, maxArea)
    }

    return maxArea
}

fun calcArea(stack: ArrayDeque<Int>, a: IntArray, index: Int): Int {
    val top = stack.removeFirst()
//    println("Calc area with ${a[top]} at index $top; cur index is $index; stack is ${if(stack.isEmpty()) "empty" else "not empty"}")
    return if (stack.isEmpty()) (index * a[top]) else ((index - stack.first - 1) * a[top])
}

fun main(args: Array<String>) {
//    println(largestRectangleInHistogram(intArrayOf(1, 2, 3, 5, 2, 3, 4)))
    println(largestRectangleInHistogram(intArrayOf(5, 2, 3, 5, 4)))
//    println(largestRectangleInHistogram(intArrayOf(1, 2, 3, 5, 3)))
//    println(largestRectangleInHistogram(intArrayOf(1, 2, 4)))
}