package com.yujin.fontchecker

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import com.yujin.fontchecker.databinding.ActivityMainBinding
import com.yujin.fontchecker.model.TextModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val context: Context = this
    private lateinit var binding: ActivityMainBinding
    private val textModel = TextModel()

    private val colorDialog = ColorDialog
    private val sizeDialog = SizeDialog
    private val fontDialog = FontDialog


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
            btnSettingTextFont.setOnClickListener(activity)
            btnSettingTextColor.setOnClickListener(activity)
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnDelete -> textModel.text.value = DEFAULT_TEXT

            binding.btnSettingBg ->
                colorDialog.show(context)
                        .onConfirm {
                            textModel.bgColor.value = colorDialog.color
                            colorDialog.dismiss()
                        }
                        .onCancel {
                            colorDialog.dismiss()
                        }

            binding.btnSettingTextColor ->
                colorDialog.show(context)
                        .onConfirm {
                            textModel.textColor.value = colorDialog.color
                            colorDialog.dismiss()
                        }
                        .onCancel {
                            colorDialog.dismiss()
                        }

            binding.btnSettingTextSize ->
                sizeDialog.show(this)
                        .onConfirm {
                            textModel.textSize.value = sizeDialog.size
                            sizeDialog.dismiss()
                        }
                        .onCancel {
                            sizeDialog.dismiss()
                        }

            binding.btnSettingTextFont ->
                fontDialog.show(context, textModel.text.value)
                        .onConfirm {
                            binding.tvOutput.typeface = fontDialog.fontRes
                            fontDialog.dismiss()
                        }
                        .onCancel {
                            fontDialog.dismiss()
                        }
        }
    }

}