package com.yujin.fontchecker;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import com.yujin.fontchecker.databinding.LayoutFontDialogBinding;
import com.yujin.fontchecker.model.FontModel;

public class FontDialog implements View.OnClickListener {
    private Context                 mContext;
    private Dialog                  mDialog;

    private FontModel               mModel;
    private LayoutFontDialogBinding mBinding;


    // Singleton
    private static FontDialog uniqueInstance = new FontDialog();
    public static FontDialog getInstance() {
        return uniqueInstance;
    }

    public FontDialog show(@NonNull Context context, String text) {
        mContext = context;

        mDialog = new Dialog(mContext, R.style.ChangeDialogStyle);
        mDialog.setCancelable(true);
        mDialog.setCanceledOnTouchOutside(true);

        mModel = new FontModel();
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mDialog.getContext()), R.layout.layout_font_dialog, null, false);
        mDialog.setContentView(mBinding.getRoot());

        mBinding.setLifecycleOwner((LifecycleOwner) mContext);
        mBinding.setModel(mModel);
        mModel.text.setValue(text);

        try {
            mDialog.show();
        } catch (Exception e) {
            mDialog = null;
        }

        mBinding.btnLight.setOnClickListener(this);
        mBinding.btnRegular.setOnClickListener(this);
        mBinding.btnBold.setOnClickListener(this);

        return getInstance();
    }

    public FontDialog onConfirm(View.OnClickListener onClickListener) {
        mBinding.btnConfirm.setOnClickListener(onClickListener);
        return getInstance();
    }

    public FontDialog onCancel(View.OnClickListener onClickListener) {
        mBinding.btnCancel.setOnClickListener(onClickListener);
        return getInstance();
    }

    public int getFont() {
        return mModel.font.getValue();
    }

    public Typeface getFontRes() {
        return ResourcesCompat.getFont(mContext, mModel.font.getValue());
    }

    public void dismiss() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }

    @Override
    public void onClick(View view) {
        if (view == mBinding.btnLight) {
            mModel.font.setValue(R.font.notosans_cjk_kr_light);
        }
        else if (view == mBinding.btnRegular) {
            mModel.font.setValue(R.font.notosans_cjk_kr_regular);
        }
        else if (view == mBinding.btnBold) {
            mModel.font.setValue(R.font.notosans_cjk_kr_bold);
        }
        mBinding.tvFont.setTypeface(ResourcesCompat.getFont(mContext, mModel.font.getValue()));
    }
}
