package com.yujin.fontchecker

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.yujin.fontchecker.databinding.LayoutColorDialogBinding
import com.yujin.fontchecker.model.ColorModel

class ColorDialog(private val context: Context) {
    private var dialog: Dialog? = null
    private var colorModel: ColorModel? = null
    private var binding: LayoutColorDialogBinding? = null

    val color: Int?
        get() = colorModel?.color?.value
    val red: Int?
        get() = colorModel?.red?.value
    val green: Int?
        get() = colorModel?.green?.value
    val blue: Int?
        get() = colorModel?.blue?.value

    fun show() {
        colorModel = ColorModel()
        dialog = Dialog(context, R.style.ChangeDialogStyle).apply {
            setCanceledOnTouchOutside(true)
        }

        binding = DataBindingUtil.inflate(LayoutInflater.from(dialog?.context), R.layout.layout_color_dialog, null, false)
        binding?.run {
            setLifecycleOwner(context as LifecycleOwner)
            model = colorModel
        }

        dialog?.setContentView(binding!!.root)

        try {
            dialog?.show()
        } catch (e: Exception) {
            dialog = null
        }
    }

    fun onConfirm(onClickListener: (View) -> Unit) {
        binding?.btnConfirm?.setOnClickListener(onClickListener)
    }

    fun onCancel(onClickListener: (View) -> Unit) {
        binding?.btnCancel?.setOnClickListener(onClickListener)
    }

    fun dismiss() {
        dialog?.dismiss()
    }
}