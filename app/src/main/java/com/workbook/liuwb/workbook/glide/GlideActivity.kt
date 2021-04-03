package com.workbook.liuwb.workbook.glide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_glide.*


class GlideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        val toolbar = glide_toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 请求配置
        val requestOptions = RequestOptions.bitmapTransform(CircleCrop())
                .override(Target.SIZE_ORIGINAL) // 指定图片大小，SIZE_ORIGINAL表示原始尺寸
                .placeholder(R.drawable.ic_launcher_background) // 加载完成前的占位符
                .error(R.drawable.bg) // 加载失败的占位图
                .skipMemoryCache(true)

        // 缩略图
        val thumbnailRequest = Glide.with(this).load(R.drawable.arrow)

        Glide.with(this)
                .load(URL_GIF) // 加载地址
                .thumbnail(thumbnailRequest)
                .apply(requestOptions)
                .into(glide_imageView)


    }

    companion object {
        private const val URL_JPG = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg"
        private const val URL_GIF = "http://p1.pstatp.com/large/166200019850062839d3"
    }
}
