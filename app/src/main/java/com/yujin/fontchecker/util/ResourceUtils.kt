package com.yujin.fontchecker.util

import android.graphics.Color

// RGB Color
const val RGB_COLOR_MIN = 0
const val RGB_COLOR_MAX = 255

val RGB_BLACK: Int
    get() = getRGB(RGB_COLOR_MIN, RGB_COLOR_MIN, RGB_COLOR_MIN)
val RGB_WHITE: Int
    get() = getRGB(RGB_COLOR_MAX, RGB_COLOR_MAX, RGB_COLOR_MAX)

fun getRGB(red: Int, green: Int, blue: Int) = Color.rgb(red, green, blue)