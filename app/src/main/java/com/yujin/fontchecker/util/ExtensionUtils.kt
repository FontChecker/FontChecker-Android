package com.yujin.fontchecker.util

import android.content.res.Resources
import kotlin.math.roundToInt

val Int.dp: Int
    get() = this.floatDp.roundToInt()
val Float.dp: Int
    get() = this.floatDp.roundToInt()

val Int.floatDp: Float
    get() = this * (Resources.getSystem().displayMetrics.density)
val Float.floatDp: Float
    get() = this * (Resources.getSystem().displayMetrics.density)