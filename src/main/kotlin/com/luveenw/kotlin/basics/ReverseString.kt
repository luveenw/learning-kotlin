package com.luveenw.kotlin.basics

import java.util.*

const val DELIM = " "

fun reverse(str: String): String {
    val arr = str.toCharArray()
    val n = arr.size - 1

    for (i in 0..(n/2)) {
        val temp = arr[n - i]
        arr[n - i] = str[i]
        arr[i] = temp
    }

    return String(arr)
}
fun reverseWords(str: String): String {
    val reverse = reverse(str)
    val tokens = StringTokenizer(reverse, DELIM)
    val result = StringBuilder()

    while (tokens.hasMoreTokens()) {
        result.append(reverse(tokens.nextToken()))
        result.append(DELIM)
    }

    return result.toString()
}

fun main(args: Array<String>) {
    println(reverse("Hello there"))
    println(reverseWords("Hello there"))
}