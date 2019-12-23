package com.yujin.fontchecker.model;

import androidx.lifecycle.MutableLiveData;
import com.yujin.fontchecker.R;

public class FontModel {
    public MutableLiveData<String>  text = new MutableLiveData<>();
    public MutableLiveData<Integer> font = new MutableLiveData<>();

    public FontModel() {
        text.setValue("");
        font.setValue(R.font.notosans_cjk_kr_regular);
    }
}
