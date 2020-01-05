package com.yujin.fontchecker

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yujin.fontchecker.databinding.ActivityMainBinding
import com.yujin.fontchecker.model.TextModel
import com.yujin.fontchecker.util.DEFAULT_TEXT

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val textModel = TextModel()

    private val colorDialog = ColorDialog(this)
    private val sizeDialog = SizeDialog(this)
    private val fontDownloadDialog = FontDownloadDialog(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.run {
            val activity = this@MainActivity

            setLifecycleOwner(activity)
            model = textModel

            btnDelete.setOnClickListener(activity)
            btnSettingBg.setOnClickListener(activity)
            btnSettingTextSize.setOnClickListener(activity)
            btnSettingTextColor.setOnClickListener(activity)
            btnSettingFont.setOnClickListener(activity)
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnDelete -> textModel.text.value = DEFAULT_TEXT

            binding.btnSettingBg ->
                colorDialog.show()
                        .onConfirm {
                            textModel.bgColor.value = colorDialog.color
                            colorDialog.dismiss()
                        }
                        .onCancel {
                            colorDialog.dismiss()
                        }

            binding.btnSettingTextColor ->
                colorDialog.show()
                        .onConfirm {
                            textModel.textColor.value = colorDialog.color
                            colorDialog.dismiss()
                        }
                        .onCancel {
                            colorDialog.dismiss()
                        }

            binding.btnSettingTextSize ->
                sizeDialog.show()
                        .onConfirm {
                            textModel.textSize.value = sizeDialog.size
                            sizeDialog.dismiss()
                        }
                        .onCancel {
                            sizeDialog.dismiss()
                        }

            binding.btnSettingFont ->
                fontDownloadDialog.show(textModel.text.value)
                        .onConfirm {
                            textModel.typeface.value = fontDownloadDialog.fontFamily
                            fontDownloadDialog.dismiss()
                        }
                        .onCancel { fontDownloadDialog.dismiss() }
        }
    }

}