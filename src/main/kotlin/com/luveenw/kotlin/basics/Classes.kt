package com.luveenw.kotlin.basics

class SimpleSpice() {
    val name: String = "curry"
    val spiciness: String = "mild"
    val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 5
                "hot" -> 1
                else -> 3
            }
        }
}

fun main(args: Array<String>) {
    val spice = SimpleSpice()
    println("${spice.name} is ${spice.spiciness}, level ${spice.heat}")
}