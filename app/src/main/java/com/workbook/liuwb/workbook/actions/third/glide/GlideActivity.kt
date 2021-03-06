package com.workbook.liuwb.workbook.actions.third.glide

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.databinding.ActivityGlideBinding

class GlideActivity : AppCompatActivity() {

    private val binding: ActivityGlideBinding by lazy {
        ActivityGlideBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.glideToolbar)
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
            .into(binding.glideImageView)

        Glide.with(this)
            .load(URL_GIF) // 加载地址
            .preload() // 预加载

        Glide.with(this)
            .load(URL_GIF)
            .skipMemoryCache(true) // 跳过内存缓存
            .diskCacheStrategy(DiskCacheStrategy.NONE) // 不使用磁盘缓存
            .into(binding.glideImageView)

        Glide.get(this).clearMemory() // 清理内存缓存
        Glide.get(this).clearDiskCache() // 清理硬盘缓存

    }

    companion object {
        private const val URL_JPG = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg"
        private const val URL_GIF = "http://p1.pstatp.com/large/166200019850062839d3"
    }
}
