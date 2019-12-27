package com.yujin.fontchecker.model

import android.widget.SeekBar
import androidx.lifecycle.MutableLiveData
import com.yujin.fontchecker.util.DEFAULT_TEXT_SIZE

class SizeModel(_size: Int? = DEFAULT_TEXT_SIZE) {
    val size = MutableLiveData<Int>(_size)

    fun onSizeProgressChanged(seekBar: SeekBar, progressValue: Int, fromUser: Boolean) {
        size.value = progressValue
    }
}