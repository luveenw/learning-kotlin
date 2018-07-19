package com.luveenw.kotlin.interviewing

import java.util.*

class MaxStack {
    private val stack: Stack<Int> = Stack()
    private val maxes: Stack<Int> = Stack()

    val max: Int
        get() = this.maxes.peek()

    fun push(num: Int) {
        val curMax = if (this.maxes.isEmpty()) Integer.MIN_VALUE else this.maxes.peek()
        this.stack.push(num)
        this.maxes.push(if (curMax > num) curMax else num)
    }

    fun pop(): Int {
        val result = this.stack.pop()
        this.maxes.pop()
        return result
    }
}

fun main(args: Array<String>) {
    val stack = MaxStack()

    stack.push(1)
    stack.push(3)
    stack.push(2)
    stack.push(5)
    stack.push(3)

    println(stack.max)

    stack.pop()
    stack.pop()

    println(stack.max)
}