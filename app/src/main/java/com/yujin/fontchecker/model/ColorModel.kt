package com.yujin.fontchecker.model

import android.widget.SeekBar
import androidx.lifecycle.MutableLiveData
import com.yujin.fontchecker.util.RGB_COLOR_MIN
import com.yujin.fontchecker.util.getRGB

class ColorModel {
    val red = MutableLiveData(RGB_COLOR_MIN)
    val green = MutableLiveData(RGB_COLOR_MIN)
    val blue = MutableLiveData(RGB_COLOR_MIN)
    val color = MutableLiveData(RGB_COLOR_MIN)

    private val rgb: Int
        get() = getRGB(red.value!!, green.value!!, blue.value!!)

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