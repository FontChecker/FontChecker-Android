package com.yujin.fontchecker.model

import android.widget.SeekBar
import androidx.lifecycle.MutableLiveData

class SizeModel {
    companion object {
        const val DEFAULT_SIZE = 10
    }

    val size = MutableLiveData<Int>()

    constructor() : this(DEFAULT_SIZE)
    constructor(_size: Int) {
        size.value = _size
    }

    fun onSizeProgressChanged(seekBar: SeekBar, progressValue: Int, fromUser: Boolean) {
        size.value = progressValue
    }
}