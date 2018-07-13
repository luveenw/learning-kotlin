package com.luveenw.kotlin.basics

fun main(args: Array<String>) {
    val fortuneCookie = fortuneCookie()
    do {
        println("Your fortune is: $fortuneCookie")
    } while(!fortuneCookie.startsWith("Take it easy"))
}

fun fortuneCookie(): String {
    print("Enter your birthday: ")
    val birthday = readLine()?.toIntOrNull() ?: 1
    val fortunes = listOf(
            "Things will go well for you today.",
            "You will have a great day!",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.")

    return fortunes[when (birthday) {
        28, 31 -> 5
        in 1..7 -> 3
        else -> birthday % fortunes.size
    }]
}