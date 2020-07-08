package com.workbook.liuwb.workbook

import android.content.SharedPreferences

fun SharedPreferences.modify(block: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.block()
    editor.apply()
}

/// 实现和List.maxBy相同的功能
fun <T, R : Comparable<R>> List<T>.findMaxBy(block: (T) -> R): T? {
    if (isEmpty()) return null

    var maxElement: T = get(0)
    var maxValue: R = block(maxElement)

    for (element: T in this) {
        val value: R = block(element)
        if (value > maxValue) {
            maxElement = element
            maxValue = value
        }
    }

    return maxElement
}
