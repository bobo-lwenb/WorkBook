package com.workbook.liuwb.mylibrary.utils.cache.lru

import android.graphics.Bitmap
import android.util.LruCache
import android.widget.ImageView

class SimpleImageLoader private constructor() {
    private val mLruCache: LruCache<String, Bitmap>
    fun displayImage(view: ImageView, url: String) {
        val bitmap = getBitmapFromCache(url)
        if (bitmap != null) {
            view.setImageBitmap(bitmap)
        } else {
            downLoadImage(view, url)
        }
    }

    fun getBitmapFromCache(url: String): Bitmap? {
        return mLruCache[url]
    }

    fun putBitmapToCache(bitmap: Bitmap?, url: String) {
        if (bitmap == null) return
        mLruCache.put(url, bitmap)
    }

    fun downLoadImage(view: ImageView?, url: String) {}

    companion object {
        val instance by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SimpleImageLoader()
        }
    }

    init {
        val maxSize = (Runtime.getRuntime().maxMemory() / 8).toInt()
        mLruCache = object : LruCache<String, Bitmap>(maxSize) {
            override fun sizeOf(key: String?, value: Bitmap): Int {
                return value.byteCount
            }
        }
    }
}