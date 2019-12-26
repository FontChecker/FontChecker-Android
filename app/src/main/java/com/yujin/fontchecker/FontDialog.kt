package com.yujin.fontchecker

import android.app.Dialog
import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.yujin.fontchecker.databinding.LayoutFontDialogBinding
import com.yujin.fontchecker.model.FontModel
import java.lang.Exception

object FontDialog : View.OnClickListener {
    private var context: Context? = null
    private var dialog: Dialog? = null
    private var fontModel: FontModel? = null
    private var binding: LayoutFontDialogBinding? = null

    val font: Int
        get() = fontModel?.font?.value ?: R.font.notosans_cjk_kr_regular
    val fontRes: Typeface?
        get() = context?.let { context -> ResourcesCompat.getFont(context, font) }

    fun show(_context: Context, _text: String?): FontDialog {
        context = _context

        fontModel = FontModel(_text)
        dialog = Dialog(context, R.style.ChangeDialogStyle).apply {
            setCanceledOnTouchOutside(true)
        }

        binding = DataBindingUtil.inflate(LayoutInflater.from(dialog?.context), R.layout.layout_font_dialog, null, false)
        binding?.run {
            val onClickListener = this@FontDialog

            setLifecycleOwner(context as LifecycleOwner)
            model = fontModel

            btnLight.setOnClickListener(onClickListener)
            btnRegular.setOnClickListener(onClickListener)
            btnBold.setOnClickListener(onClickListener)
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

    fun onConfirm(onClickListener: (View) -> Unit): FontDialog {
        binding?.btnConfirm?.setOnClickListener(onClickListener)
        return this
    }

    fun onCancel(onClickListener: (View) -> Unit): FontDialog {
        binding?.btnCancel?.setOnClickListener(onClickListener)
        return this
    }

    fun dismiss() {
        dialog?.dismiss()
    }

    override fun onClick(v: View?) {
        when (v) {
            binding?.btnLight -> fontModel?.font?.value = R.font.notosans_cjk_kr_light
            binding?.btnRegular -> fontModel?.font?.value = R.font.notosans_cjk_kr_regular
            binding?.btnBold -> fontModel?.font?.value = R.font.notosans_cjk_kr_bold
        }
        binding?.tvFont?.typeface = fontRes
    }
}