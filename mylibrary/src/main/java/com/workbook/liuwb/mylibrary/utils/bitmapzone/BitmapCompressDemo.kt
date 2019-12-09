package com.workbook.liuwb.mylibrary.utils.bitmapzone

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.widget.ImageView

class BitmapCompressDemo {
    fun compressBitmap(img: ImageView, img2: ImageView) {
        // 压缩bitmap
        val imgPath = Environment.getRootDirectory().absolutePath
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true // 打开只读图片bounds信息
        BitmapFactory.decodeFile(imgPath) // 在不把图片加载进内存的情况下，获取图片信息
        val width = options.outWidth
        options.inSampleSize = width / 200
        options.inPreferredConfig = Bitmap.Config.RGB_565 // 改变图片的解码率，降低单个像素占用的内存
        options.inJustDecodeBounds = false // 关闭只读图片bounds信息
        val bitmap = BitmapFactory.decodeFile(imgPath, options) // 真正把图片加载到内存
        img.setImageBitmap(bitmap)

        // inBitmap的使用
        val option2 = BitmapFactory.Options()
        option2.inBitmap = bitmap // 重用内存，但是之后设置的图片占用的内存不得大于bitmap的内存占用
        val bitmap2 = BitmapFactory.decodeFile(imgPath, option2)
        img2.setImageBitmap(bitmap2)
    }

    fun ratio1(filePath: String, pixelW: Int, pixelH: Int): Bitmap {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        options.inPreferredConfig = Bitmap.Config.RGB_565
        BitmapFactory.decodeFile(filePath, options)
        val originalW = options.outWidth
        val originalH = options.outHeight

        options.inSampleSize = getInSampleSize1(originalW, originalH, pixelW, pixelH)
        options.inJustDecodeBounds = false
        return BitmapFactory.decodeFile(filePath, options)
    }

    private fun getInSampleSize1(originalW: Int, originalH: Int, pixelW: Int, pixelH: Int): Int {
        var inSampleSize = 1

        if (originalW > originalH && originalW > pixelW) {
            inSampleSize = originalW / pixelW
        } else if (originalW < originalH && originalH > pixelH) {
            inSampleSize = originalH / pixelH
        }

        if (inSampleSize <= 0) {
            inSampleSize = 1
        }

        return inSampleSize
    }

    fun ratio2(reeId: Int, pixelW: Int, pixelH: Int): Bitmap {
        val optios = BitmapFactory.Options()
        optios.inJustDecodeBounds = true
        optios.inPreferredConfig = Bitmap.Config.RGB_565
        BitmapFactory.decodeResource(Resources.getSystem(), reeId, optios)

        optios.inSampleSize = getInSampleSize2(optios, pixelW, pixelH)
        optios.inJustDecodeBounds = false
        return BitmapFactory.decodeResource(Resources.getSystem(), reeId, optios)
    }

    private fun getInSampleSize2(optios: BitmapFactory.Options, pixelW: Int, pixelH: Int): Int {
        var inSampleSize = 1
        val originalW = optios.outWidth
        val originalH = optios.outHeight

        if (originalW > pixelW || originalH > pixelH) {
            val halfW = originalW / 2
            val halfH = originalH / 2
            while (halfW / inSampleSize >= pixelW && halfH / inSampleSize >= pixelH) {
                inSampleSize *= 2
            }
        }
        return inSampleSize
    }
}