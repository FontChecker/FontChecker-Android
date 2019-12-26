package com.yujin.fontchecker.model

import android.graphics.Color
import android.widget.SeekBar
import androidx.lifecycle.MutableLiveData

class ColorModel {
    companion object {
        private const val DEFAULT = 0
    }

    val red = MutableLiveData<Int>().apply {
        value = DEFAULT
    }
    val green = MutableLiveData<Int>().apply {
        value = DEFAULT
    }
    val blue = MutableLiveData<Int>().apply {
        value = DEFAULT
    }
    val color = MutableLiveData<Int>().apply {
        value = rgb
    }

    private val rgb: Int
        get() = Color.rgb(red.value!!, green.value!!, blue.value!!)

    fun onRedProgressChanged(seekBar: SeekBar, progressValue: Int, fromUser: Boolean) {
        red.value = progressValue
        color.value = rgb
    }

    fun onGreenProgressChanged(seekBar: SeekBar, progressValue: Int, fromUser: Boolean) {
        green.value = progressValue
        color.value = rgb
    }

    fun onBlueProgressChanged(seekBar: SeekBar, progressValue: Int, fromUser: Boolean) {
        blue.value = progressValue
        color.value = rgb
    }
}