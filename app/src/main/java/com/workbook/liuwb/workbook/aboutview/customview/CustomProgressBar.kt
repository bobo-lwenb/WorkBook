package com.workbook.liuwb.workbook.aboutview.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import com.workbook.liuwb.workbook.R

/**
 * 这个例子的onMeasure方法是不完善的，没有测量宽高的过程。另一个问题是thread在执行过程中有问题
 */
class CustomProgressBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mFirstColor: Int = 0
    private var mSecondColor: Int = 0
    private var mCircleWidth: Int = 0
    private var mSpeed: Int = 0

    private val mPaint: Paint
    private var mProgress: Int = 0

    private lateinit var oval: RectF
    private var center: Int = 0
    private var radius: Int = 0
    private var isNext = false
    private var isFirst = true

    init {
        val typeArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar, defStyleAttr, 0)
        for (i in 0 until typeArray.indexCount) {
            when (val attr = typeArray.getIndex(i)) {
                R.styleable.CustomProgressBar_firstColor -> mFirstColor = typeArray.getColor(attr, Color.GREEN)
                R.styleable.CustomProgressBar_secondColor -> mSecondColor = typeArray.getColor(attr, Color.RED)
                R.styleable.CustomProgressBar_circleWidth -> {
                    val defaultSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 20f, resources.displayMetrics)
                    mCircleWidth = typeArray.getDimensionPixelSize(attr, defaultSize.toInt())
                }
                R.styleable.CustomProgressBar_speed -> mSpeed = typeArray.getInt(attr, 20)
            }
        }
        typeArray.recycle()

        mPaint = Paint()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas) {
        if (isFirst) {
            isFirst = false
            center = width / 2
            radius = center - mCircleWidth / 2

            mPaint.strokeWidth = mCircleWidth.toFloat()
            mPaint.isAntiAlias = true
            mPaint.style = Paint.Style.STROKE

            val left = (center - radius).toFloat()
            val top = (center - radius).toFloat()
            val right = (center + radius).toFloat()
            val bottom = (center + radius).toFloat()
            oval = RectF(left, top, right, bottom)
            WorkThread().start()
        }

        if (!isNext) {
            mPaint.color = mFirstColor // 设置圆环的颜色
            canvas.drawCircle(center.toFloat(), center.toFloat(), radius.toFloat(), mPaint) // 画出圆环
            mPaint.color = mSecondColor// 设置圆环的颜色
            canvas.drawArc(oval, -90f, mProgress.toFloat(), false, mPaint)
        } else {
            mPaint.color = mSecondColor // 设置圆环的颜色
            canvas.drawCircle(center.toFloat(), center.toFloat(), radius.toFloat(), mPaint) // 画出圆环
            mPaint.color = mFirstColor // 设置圆环的颜色
            canvas.drawArc(oval, -90f, mProgress.toFloat(), false, mPaint)
        }
    }

    inner class WorkThread : Thread() {
        override fun run() {
            while (true) {
                mProgress++
                if (mProgress == 360) {
                    mProgress = 0
                    isNext = !isNext
                }
                postInvalidate()
                try {
                    sleep(mSpeed.toLong())
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
    }
}

