package com.yujin.fontchecker.model;

import android.graphics.Color;
import android.widget.SeekBar;

import androidx.lifecycle.MutableLiveData;

public class ColorModel {
    public MutableLiveData<Integer> color = new MutableLiveData<>();
    public MutableLiveData<Integer> red = new MutableLiveData<>();
    public MutableLiveData<Integer> green = new MutableLiveData<>();
    public MutableLiveData<Integer> blue = new MutableLiveData<>();

    public ColorModel() {
        red.setValue(0);
        green.setValue(0);
        blue.setValue(0);
        color.setValue(Color.rgb(0,0,0));
    }

    public void onRedProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
        red.setValue(progressValue);
        color.setValue(Color.rgb(red.getValue(), green.getValue(), blue.getValue()));
    }

    public void onGreenProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
        green.setValue(progressValue);
        color.setValue(Color.rgb(red.getValue(), green.getValue(), blue.getValue()));
    }

    public void onBlueProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
        blue.setValue(progressValue);
        color.setValue(Color.rgb(red.getValue(), green.getValue(), blue.getValue()));
    }
}
