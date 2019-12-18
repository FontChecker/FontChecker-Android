package captain.wonjong.fontchecker.model;

import android.graphics.Color;
import android.widget.SeekBar;

import androidx.lifecycle.MutableLiveData;

public class SizeModel {
    public MutableLiveData<Integer> size = new MutableLiveData<>();

    public SizeModel() {
        size.setValue(10);
    }

    public void onSizeProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
        size.setValue(progressValue);
    }
}
