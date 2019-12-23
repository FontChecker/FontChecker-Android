package com.yujin.fontchecker.util;

import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingConversion;

public class BindingUtils {

    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }

    @BindingAdapter({"bind:setBg"})
    public static void setBg(View view, @ColorInt int color) {
        try {
            view.setBackgroundColor(color);
        } catch (Exception e) {
            Log.e("setBg Error :: ", e.toString());
        }
    }

    @BindingAdapter({"bind:setTextColor"})
    public static void setTextColor(TextView textView, @ColorInt int color) {
        try {
            textView.setTextColor(color);
        } catch (Exception e) {
            Log.e("setTextColor Error :: ", e.toString());
        }
    }

    @BindingAdapter({"bind:setTextSize"})
    public static void setTextSize(TextView textView, @ColorInt int size) {
        try {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
        } catch (Exception e) {
            Log.e("setTextSize Error :: ", e.toString());
        }
    }

    @BindingAdapter("setTextWatcher")
    public static void setTextWatcher(EditText editText, TextWatcher textWatcher) {
        try {
            editText.addTextChangedListener(textWatcher);
        } catch (Exception e) {
            Log.e("setTxtWatcher Error :: ", e.toString());
        }
    }
}
