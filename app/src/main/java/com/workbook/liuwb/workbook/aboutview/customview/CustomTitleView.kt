package com.workbook.liuwb.workbook.aboutview.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import com.workbook.liuwb.workbook.R

/**
 * 自定义View基本用法
 */
class CustomTitleView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private lateinit var mTitleText: String
    private var mTitleTextColor: Int = 0
    private var mTitleTextSize: Int = 0

    /**
     * 用于保存文本的矩形边界
     */
    private var mBound: Rect
    private var mPaint: Paint

    init {
        // 加载自定义属性
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0)
        // 遍历自定义属性并读取属性值
        for (i in 0 until typedArray.indexCount) {
            when (val attr = typedArray.getIndex(i)) {
                R.styleable.CustomTitleView_titleText -> mTitleText = typedArray.getString(attr).toString()
                R.styleable.CustomTitleView_titleTextColor -> mTitleTextColor = typedArray.getColor(attr, Color.BLACK)
                R.styleable.CustomTitleView_titleTextSize -> {
                    val defaultSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16f, resources.displayMetrics).toInt()
                    mTitleTextSize = typedArray.getDimensionPixelSize(attr, defaultSize)
                }
            }
        }
        // 回收
        typedArray.recycle()

        mPaint = Paint()
        mPaint.textSize = mTitleTextSize.toFloat()
        mPaint.color = mTitleTextColor
        mBound = Rect()
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length, mBound)

        this.setOnClickListener {
            mTitleText = randomText()
            postInvalidate()
        }
    }

    private fun randomText(): String {
        val random = java.util.Random()
        val set = HashSet<Int>()
        while (set.size < 4) {
            val randomInt = random.nextInt(10)
            set.add(randomInt)
        }
        val stringBuilder = StringBuilder()
        for (i in set) {
            stringBuilder.append(i)
        }
        return stringBuilder.toString()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)

        val heightMode = MeasureSpec.getSize(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val width: Int
        val height: Int

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize
        } else {
            mPaint.textSize = mTitleTextSize.toFloat()
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length, mBound)
            val textWidth = mBound.width()
            val desireWith = paddingLeft + paddingRight + textWidth // 文本的宽度+左右padding就是控件的宽度
            width = desireWith
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize
        } else {
            mPaint.textSize = mTitleTextSize.toFloat()
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length, mBound)
            val textHeight = mBound.height()
            val desireHeight = paddingTop + paddingBottom + textHeight // 文本的高度+上下padding就是控件的高度
            height = desireHeight
        }

        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mPaint.color = Color.YELLOW
        canvas.drawRect(0f, 0f, measuredWidth.toFloat(), measuredHeight.toFloat(), mPaint) // 画出控件的大小，就是背景

        mPaint.color = mTitleTextColor
        val startX = (width / 2 - mBound.width() / 2).toFloat() // 绘制文本的X坐标
        val startY = (height / 2 + mBound.height() / 2).toFloat() // 绘制文本的Y坐标
        canvas.drawText(mTitleText, startX, startY, mPaint) // 在背景上绘制文件
    }
}
