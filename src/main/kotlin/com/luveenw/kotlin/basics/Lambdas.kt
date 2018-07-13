package com.luveenw.kotlin.basics

import java.util.*

val rollDice: (Int) -> Int = { if (it == 0) 0 else 1 + Random().nextInt(it) }
fun rollDiceFn(sides: Int): Int = if (sides == 0) 0 else Random().nextInt(sides) + 1

fun gamePlay(diceRoll: Int) = println("Calling with lambda: ${diceRoll}")
fun gamePlay4(func: (Int) -> Int) = println("Calling with function reference: ${func(4)}")

fun main(args: Array<String>) {
    repeat(15) {
        gamePlay(rollDice(7))
        gamePlay4(::rollDiceFn)
        Thread.sleep(500)
    }
}