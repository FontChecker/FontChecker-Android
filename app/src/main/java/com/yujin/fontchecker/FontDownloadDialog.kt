package com.yujin.fontchecker

import android.app.Dialog
import android.content.Context
import android.graphics.Typeface
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.yujin.fontchecker.databinding.LayoutFontDownloadDialogBinding
import com.yujin.fontchecker.model.FontFamilyModel
import com.yujin.fontchecker.util.*
import java.io.*
import java.lang.Exception

class FontDownloadDialog(private val context: Context) : View.OnClickListener {
    private var dialog: Dialog? = null
    private var fontFamilyModel: FontFamilyModel? = null
    private var binding: LayoutFontDownloadDialogBinding? = null

    private val fontFolder by lazy { context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) }
    private val fontFolderPath by lazy { "${fontFolder?.absolutePath}${File.separator}" }

    val fontFamily: Typeface?
        get() = fontFamilyModel?.fontFamily?.value

    fun show(_text: String?): FontDownloadDialog {
        fontFamilyModel = FontFamilyModel(_text)
        dialog = Dialog(context, R.style.ChangeDialogStyle).apply {
            setCanceledOnTouchOutside(true)
        }

        binding = DataBindingUtil.inflate(LayoutInflater.from(dialog?.context), R.layout.layout_font_download_dialog, null, false)
        binding?.run {
            setLifecycleOwner(context as LifecycleOwner)
            model = fontFamilyModel
            dialog?.setContentView(root)
            btnDownload.setOnClickListener(this@FontDownloadDialog)
        }

        setFontList()

        try {
            dialog?.show()
        } catch (e: Exception) {
            dialog = null
        } finally {
            return this
        }
    }

    fun onConfirm(onClickListener: (View) -> Unit): FontDownloadDialog {
        binding?.btnConfirm?.setOnClickListener(onClickListener)
        return this
    }

    fun onCancel(onClickListener: (View) -> Unit): FontDownloadDialog {
        binding?.btnCancel?.setOnClickListener(onClickListener)
        return this
    }

    fun dismiss() {
        dialog?.dismiss()
    }

    private fun fontDownload(url: String) {
        progressDownload(true)
        val isSuccess = FontDownloader(fontFolderPath).execute(url).get()
        if (isSuccess) {
            setFontList()
        } else {
            Toast.makeText(context, "다운로드에 실패하였습니다.", Toast.LENGTH_SHORT).show()
        }
        progressDownload(false)
    }

    private fun progressDownload(isStart: Boolean) {
        binding?.progressBar?.visibility = when (isStart) {
            true -> View.VISIBLE
            false -> View.INVISIBLE
        }
        binding?.btnDownload?.isEnabled = !isStart
    }

    private fun setFontList() {
        val fontList = FontFileLoader(fontFolderPath).execute().get()
        setFontListRadio(fontList)
    }

    private fun setFontListRadio(fontList: List<String>) {
        binding?.layoutFontFamilyList?.removeAllViews()
        for (font in fontList) {
            binding?.layoutFontFamilyList?.addView(createFontRadio(font))
        }
    }

    private fun createFontRadio(font: String) = RadioButton(context).apply {
        text = font
        setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                val fontFile = File("${fontFolderPath}${buttonView.text}")
                if (fontFile.exists()) {
                    fontFamilyModel?.fontFamily?.value = Typeface.createFromFile(fontFile)
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            binding?.btnDownload -> fontDownload(binding?.etFontUrl?.text.toString())
        }
    }
}