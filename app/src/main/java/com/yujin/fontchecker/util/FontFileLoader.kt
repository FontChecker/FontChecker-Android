package com.yujin.fontchecker.util

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.File

object FontFileLoader {
    fun loadFontFile(fontFolderPath: String) = Observable.fromCallable {
                File(fontFolderPath).listFiles().filter { it.name.isFontFile }.map { it.name }
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()) ?: null
}