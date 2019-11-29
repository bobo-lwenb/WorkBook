package com.workbook.liuwb.workbook.glide

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_glide.*

class GlideActivity : AppCompatActivity() {

    private var imageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        val toolbar = glide_toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imageView = findViewById(R.id.glide_imageView)

        val options = RequestOptions()
                .override(192, 108)
                .placeholder(R.mipmap.ic_launcher)// 占位符图片
                .error(R.mipmap.ic_launcher_round)// 加载失败图片
                .diskCacheStrategy(DiskCacheStrategy.NONE)// 关闭硬盘缓存
                .skipMemoryCache(true)// 关闭内存缓存
//                .transform(MultiTransformation())

        val factory = DrawableCrossFadeFactory.Builder(500).setCrossFadeEnabled(true).build()
        val options1 = DrawableTransitionOptions.with(factory)

        val options2 = DrawableTransitionOptions().crossFade()
        val options3 = DrawableTransitionOptions.withCrossFade()

        GlideApp.with(this)
//                 .asBitmap()
                .load(URL_JPG)
                .transition(options1)
                .apply(options)
                .thumbnail(null)
                .into(imageView!!)

    }

    companion object {

        private val URL_JPG = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg"
        private val URL_GIF = "http://p1.pstatp.com/large/166200019850062839d3"
    }
}
