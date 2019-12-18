package captain.wonjong.fontchecker.model;

import android.graphics.Typeface;

import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.MutableLiveData;
import captain.wonjong.fontchecker.R;

public class FontModel {
    public MutableLiveData<String>  text = new MutableLiveData<>();
    public MutableLiveData<Integer> font = new MutableLiveData<>();

    public FontModel() {
        text.setValue("");
        font.setValue(R.font.notosans_cjk_kr_regular);
    }
}
