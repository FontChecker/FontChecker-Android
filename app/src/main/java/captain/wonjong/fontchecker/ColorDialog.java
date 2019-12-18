package captain.wonjong.fontchecker;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import captain.wonjong.fontchecker.databinding.LayoutColorDialogBinding;
import captain.wonjong.fontchecker.model.ColorModel;

public class ColorDialog {
    private Context                   mContext;
    private Dialog                    mDialog;

    private ColorModel                mModel;
    private LayoutColorDialogBinding  mBinding;

    // Singleton
    private static ColorDialog uniqueInstance = new ColorDialog();
    public static ColorDialog getInstance() {
        return uniqueInstance;
    }

    public ColorDialog show(@NonNull Context context) {
        mContext = context;

        mDialog = new Dialog(mContext, R.style.ChangeDialogStyle);
        mDialog.setCancelable(true);
        mDialog.setCanceledOnTouchOutside(true);

        mModel = new ColorModel();
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(mDialog.getContext()), R.layout.layout_color_dialog, null, false);
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

    public ColorDialog onConfirm(View.OnClickListener onClickListener) {
        mBinding.btnConfirm.setOnClickListener(onClickListener);
        return getInstance();
    }

    public ColorDialog onCancel(View.OnClickListener onClickListener) {
        mBinding.btnCancel.setOnClickListener(onClickListener);
        return getInstance();
    }

    public int getColor() {
        return mModel.color.getValue();
    }

    public int getRed() {
        return mModel.red.getValue();
    }

    public int getGreen() {
        return mModel.green.getValue();
    }

    public int getBlue() {
        return mModel.blue.getValue();
    }

    public void dismiss() {
        if (mDialog != null) {
            mDialog.dismiss();
        }
    }
}
