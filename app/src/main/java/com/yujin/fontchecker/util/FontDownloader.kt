package com.yujin.fontchecker.util

import android.os.AsyncTask
import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.net.URL


class FontDownloader(private val fontFolderPath: String) : AsyncTask<String, Unit, Boolean>() {
    companion object {
        private const val DEFAULT_INDEX = 0
        private const val FONT_FILE_NAME = "fonts.zip"
    }

    private fun fontDownload(downloadUrl: String? = DEFAULT_TEXT): Boolean {
        try {
            val url = URL(downloadUrl)
            val connection = url.openConnection()
            connection.connect()

            val input = BufferedInputStream(url.openStream(), 8192)
            val output = FileOutputStream("${fontFolderPath}${File.separator}${FONT_FILE_NAME}")

            val data = ByteArray(1024)
            var total = 0
            var count = 0
            while ({ count = input.read(data); count }() != END) {
                total += count
                output.write(data, 0, count)
            }

            output.flush()
            output.close()
            input.close()

        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

        return unZip()
    }

    private fun unZip(): Boolean {
        val zipFiles = File(fontFolderPath).listFiles().filter { it.name.isZipFile }

        for (zipFile in zipFiles) {
            try {
                val fileInputStream = FileInputStream(zipFile)
                val zipInputStream = ZipInputStream(BufferedInputStream(fileInputStream))

                var zipEnter: ZipEntry? = null
                val buffer = ByteArray(1024)
                var count = 0

                while ({ zipEnter = zipInputStream.nextEntry; zipEnter }() != null) {
                    val fileName = zipEnter!!.name

                    if ((!zipEnter!!.isDirectory) && fileName.isFontFile) {
                        val fileOutputStream = FileOutputStream(fontFolderPath + fileName)
                        while ({ count = zipInputStream.read(buffer); count }() != END) {
                            fileOutputStream.write(buffer, 0, count)
                        }
                        fileOutputStream.close()
                        zipInputStream.closeEntry()
                    }
                }
                zipInputStream.close()
                zipFile.delete()
            } catch (e: IOException) {
                e.printStackTrace()
                return false
            }
        }
        return true
    }

    override fun doInBackground(vararg params: String?): Boolean {
        val downloadUrl = params[DEFAULT_INDEX]
        return fontDownload(downloadUrl)
    }

}