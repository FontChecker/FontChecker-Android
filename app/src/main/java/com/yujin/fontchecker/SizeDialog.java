package com.yujin.fontchecker;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import com.yujin.fontchecker.databinding.LayoutSizeDialogBinding;
import com.yujin.fontchecker.model.SizeModel;

public class SizeDialog {
    private Context                 mContext;
    private Dialog                  mDialog;

    private SizeModel               mModel;
    private LayoutSizeDialogBinding mBinding;

    // Singleton
    private static SizeDialog uniqueInstance = new SizeDialog();
    public static SizeDialog getInstance() {
        return uniqueInstance;
    }

    public SizeDialog show(@NonNull Context context) {
        mContext = context;

        mDialog = new Dialog(mContext, R.style.ChangeDialogStyle);
        mDialog.setCancelable(true);
        mDialog.setCanceledOnTouchOutside(true);

        mModel = new SizeModel();
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mDialog.getContext()), R.layout.layout_size_dialog, null, false);
        mDialog.setContentView(mBinding.getRoot());

        mBinding.setLifecycleOwner((LifecycleOwner) mContext);
        mBinding.setModel(mModel);


        try {
            mDialog.show();
        } catch (Exception e) {
            mDialog = null;
        }

        return getInstance();
    }

    public SizeDialog onConfirm(View.OnClickListener onClickListener) {
        mBinding.btnConfirm.setOnClickListener(onClickListener);
        return getInstance();
    }

    public SizeDialog onCancel(View.OnClickListener onClickListener) {
        mBinding.btnCancel.setOnClickListener(onClickListener);
        return getInstance();
    }

    public int getSize() {
        return mModel.size.getValue();
    }

    public void dismiss() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }
}
