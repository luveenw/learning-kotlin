package com.luveenw.kotlin.basics

fun whatShouldIDoToday(mood: String, weather: String, temperature: Int) = when {
    mood == "happy" && weather == "sunny" -> "go for a walk"
    temperature < 15 -> "stay inside"
    else -> "stay home and read"
}

fun main(args: Array<String>) {
    println("You should ${whatShouldIDoToday("happy", "sunny", 10)}.")
    println("You should ${whatShouldIDoToday("happy", "overcast", 10)}.")
    println("You should ${whatShouldIDoToday("sad", "gloomy", 25)}.")
}