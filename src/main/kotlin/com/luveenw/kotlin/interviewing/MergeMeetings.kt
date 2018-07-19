package com.luveenw.kotlin.interviewing

import java.lang.Math.min
import java.lang.Math.max

fun mergeMeetings(meetings: List<Meeting>): List<Meeting> {
    val result = mutableListOf(meetings[0])

    meetings.subList(1, meetings.size).forEach {
        val meeting = result.last()

        if (meeting.end >= it.start) {
            meeting.start = min(meeting.start, it.start)
            meeting.end = max(meeting.end, it.end)
        } else {
            result.add(it)
        }
    }

    return result
}

data class Meeting(var start: Int, var end: Int) {
    override fun toString(): String = "[$start, $end]"
}

fun main(args: Array<String>) {
    val meetings = listOf(
            Meeting(10, 11),
            Meeting(12, 2),
            Meeting(11, 15),
            Meeting(16, 18))
            .sortedBy {it.start}

    mergeMeetings(meetings).forEach(System.out::println)
}