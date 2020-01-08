package com.yujin.fontchecker.model

import android.graphics.Typeface
import androidx.lifecycle.MutableLiveData
import com.yujin.fontchecker.util.DEFAULT_TEXT
import com.yujin.fontchecker.util.DEFAULT_TEXT_SIZE
import com.yujin.fontchecker.util.RGB_BLACK
import com.yujin.fontchecker.util.RGB_WHITE

class TextModel(_text: String? = DEFAULT_TEXT, _textSize: Int? = DEFAULT_TEXT_SIZE) {
    val text = MutableLiveData<String>(_text)
    val bgColor = MutableLiveData<Int>(RGB_WHITE)
    val textColor = MutableLiveData<Int>(RGB_BLACK)
    val textSize = MutableLiveData<Int>(_textSize)
    val typeface = MutableLiveData<Typeface>()
}