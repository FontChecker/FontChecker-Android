package captain.wonjong.fontchecker;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import captain.wonjong.fontchecker.databinding.ActivityMainBinding;
import captain.wonjong.fontchecker.model.TextModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Context               mContext;
    private ActivityMainBinding   mBinding;
    private TextModel             mModel;

    private ColorDialog           mColorDialog;
    private SizeDialog            mSizeDialog;
    private FontDialog            mFontDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        mModel = new TextModel();
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setLifecycleOwner(this);
        mBinding.setModel(mModel);

        mBinding.btnDelete.setOnClickListener(this);
        mBinding.btnSettingBg.setOnClickListener(this);
        mBinding.btnSettingTextSize.setOnClickListener(this);
        mBinding.btnSettingTextColor.setOnClickListener(this);
        mBinding.btnSettingTextFont.setOnClickListener(this);

        mColorDialog = ColorDialog.getInstance();
        mSizeDialog  = SizeDialog.getInstance();
        mFontDialog  = FontDialog.getInstance();
    }

    @Override
    public void onClick(View view) {
        // Delete
        if (view == mBinding.btnDelete) {
            mModel.text.setValue("");
        }

        // setting Background Color
        else if (view == mBinding.btnSettingBg) {
            mColorDialog.show(mContext)
                    .onCancel(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mColorDialog.dismiss();
                        }
                    })
                    .onConfirm(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mColorDialog.dismiss();
                            mModel.bgColor.setValue(mColorDialog.getColor());
                        }
                    });
        }

        // setting Text Color
        else if (view == mBinding.btnSettingTextColor) {
            mColorDialog.show(mContext)
                    .onCancel(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mColorDialog.dismiss();
                        }
                    })
                    .onConfirm(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mColorDialog.dismiss();
                            mModel.textColor.setValue(mColorDialog.getColor());
                        }
                    });

        }

        // setting Text Size
        else if (view == mBinding.btnSettingTextSize) {
            mSizeDialog.show(mContext)
                    .onCancel(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mSizeDialog.dismiss();
                        }
                    })
                    .onConfirm(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mSizeDialog.dismiss();
                            mModel.textSize.setValue(mSizeDialog.getSize());
                        }
                    });
        }

        // setting Text Font
        else if (view == mBinding.btnSettingTextFont) {
            mFontDialog.show(mContext, mModel.text.getValue())
                    .onCancel(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mFontDialog.dismiss();
                        }
                    })
                    .onConfirm(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mFontDialog.dismiss();
                            Typeface typeface = ResourcesCompat.getFont(mContext, mFontDialog.getFont());
                            mBinding.tvOutput.setTypeface(typeface);
                        }
                    });
        }
    }
}
