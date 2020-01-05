package com.yujin.fontchecker

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.yujin.fontchecker.databinding.LayoutSizeDialogBinding
import com.yujin.fontchecker.model.SizeModel
import com.yujin.fontchecker.util.DEFAULT_TEXT_SIZE
import java.lang.Exception

class SizeDialog(private val context: Context) {
    private var dialog: Dialog? = null
    private var sizeModel: SizeModel? = null
    private var binding: LayoutSizeDialogBinding? = null

    val size: Int
        get() = sizeModel?.size?.value ?: DEFAULT_TEXT_SIZE

    fun show(): SizeDialog {
        sizeModel = SizeModel()
        dialog = Dialog(context, R.style.ChangeDialogStyle).apply {
            setCanceledOnTouchOutside(true)
        }

        binding = DataBindingUtil.inflate(LayoutInflater.from(dialog?.context), R.layout.layout_size_dialog, null, false)
        binding?.run {
            setLifecycleOwner(context as LifecycleOwner)
            model = sizeModel
        }

        dialog?.setContentView(binding?.root)

        try {
            dialog?.show()
        } catch (e: Exception) {
            dialog = null
        } finally {
            return this
        }
    }

    fun onConfirm(onClickListener: (View) -> Unit): SizeDialog {
        binding?.btnConfirm?.setOnClickListener(onClickListener)
        return this
    }

    fun onCancel(onClickListener: (View) -> Unit): SizeDialog {
        binding?.btnCancel?.setOnClickListener(onClickListener)
        return this
    }

    fun dismiss() {
        dialog?.dismiss()
    }
}