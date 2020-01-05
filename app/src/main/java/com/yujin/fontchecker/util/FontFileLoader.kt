package com.yujin.fontchecker.util

import android.os.AsyncTask
import java.io.*

class FontFileLoader(private val fontFolderPath: String) : AsyncTask<Unit, Unit, List<String>>() {
    override fun doInBackground(vararg params: Unit?) = File(fontFolderPath).listFiles().filter { it.name.isFontFile }.map { it.name }
}