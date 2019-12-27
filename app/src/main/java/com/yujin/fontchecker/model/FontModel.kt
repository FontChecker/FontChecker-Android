package com.yujin.fontchecker.model

import androidx.lifecycle.MutableLiveData
import com.yujin.fontchecker.util.DEFAULT_FONT
import com.yujin.fontchecker.util.DEFAULT_TEXT

class FontModel(_text: String? = DEFAULT_TEXT, _font: Int? = DEFAULT_FONT) {
    val text = MutableLiveData<String>(_text)
    val font = MutableLiveData<Int>(_font)
}