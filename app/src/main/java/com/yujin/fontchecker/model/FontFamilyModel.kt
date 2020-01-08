package com.yujin.fontchecker.model

import android.graphics.Typeface
import androidx.lifecycle.MutableLiveData
import com.yujin.fontchecker.util.DEFAULT_TEXT

class FontFamilyModel(_text: String? = DEFAULT_TEXT) {
    val text = MutableLiveData(_text)
    var fontFamily = MutableLiveData<Typeface>()
}