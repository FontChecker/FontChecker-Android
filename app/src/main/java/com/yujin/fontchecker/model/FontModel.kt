package com.yujin.fontchecker.model

import androidx.lifecycle.MutableLiveData
import com.yujin.fontchecker.R

class FontModel {
    companion object {
        private const val DEFAULT_TEXT = ""
        private const val DEFAULT_FONT = R.font.notosans_cjk_kr_regular
    }

    val text = MutableLiveData<String>()
    val font = MutableLiveData<Int>()

    constructor() : this(DEFAULT_TEXT)
    constructor(_text: String?) : this(_text, DEFAULT_FONT)
    constructor(_font: Int?) : this(DEFAULT_TEXT, _font)
    constructor(_text: String?, _font: Int?) {
        text.value = _text ?: DEFAULT_TEXT
        font.value = _font ?: DEFAULT_FONT
    }
}