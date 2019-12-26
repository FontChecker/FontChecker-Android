package com.yujin.fontchecker.model

import android.graphics.Color
import androidx.lifecycle.MutableLiveData

class TextModel {
    // TODO : 각 모델 디폴트값 따로 빼고 조정
    companion object {
        const val DEFAULT_TEXT = ""
        const val DEFAULT_COLOR_MIN = 0
        const val DEFAULT_COLOR_MAX = 255
        const val DEFAULT_TEXT_SIZE = 20
    }

    val text = MutableLiveData<String>()
    val bgColor = MutableLiveData<Int>()
    val textColor = MutableLiveData<Int>()
    val textSize = MutableLiveData<Int>()

    // TODO : 나중에 수정할 때 각각 생성자 만들까 고민중 일단 지금은 하나만 만들어야지
    // TODO : 기본 color도 따로 뺄까 고민중,,
    init {
        text.value = DEFAULT_TEXT
        bgColor.value = Color.rgb(DEFAULT_COLOR_MAX, DEFAULT_COLOR_MAX, DEFAULT_COLOR_MAX)
        textColor.value = Color.rgb(DEFAULT_COLOR_MIN, DEFAULT_COLOR_MIN, DEFAULT_COLOR_MIN)
        textSize.value = DEFAULT_TEXT_SIZE
    }
}