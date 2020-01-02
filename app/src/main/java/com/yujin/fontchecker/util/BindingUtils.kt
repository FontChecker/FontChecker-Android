package com.yujin.fontchecker.util

import android.view.View
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter


@BindingAdapter("android:visibility")
fun View.setVisibility(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("bind:setBgColor")
fun setBgColor(v: View, @ColorInt color: Int) {
    v.setBackgroundColor(color)
}

@BindingAdapter("bind:setTextColor")
fun setTextColor(tv: TextView, @ColorInt color: Int) {
    tv.setTextColor(color)
}

@BindingAdapter("bind:setTextSize")
fun setTextSize(tv: TextView, size: Int) {
    tv.textSize = size.floatDp
}