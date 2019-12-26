package com.yujin.fontchecker.model;

import android.widget.SeekBar;

import androidx.lifecycle.MutableLiveData;

public class SizeModel {
    public final static int DEFAULT_SIZE = 10;
    public MutableLiveData<Integer> size = new MutableLiveData<>();

    public SizeModel() {
        size.setValue(DEFAULT_SIZE);
    }

    public void onSizeProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
        size.setValue(progressValue);
    }
}
