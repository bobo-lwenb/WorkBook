package com.workbook.liuwb.workbook.aboutview.customview

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.text.TextUtils
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View
import com.workbook.liuwb.workbook.R
import kotlin.math.max
import kotlin.math.min

/**
 * 一个Image、一个Text的的自定义View
 */
class CustomImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private lateinit var mImage: Bitmap
    private var mImageScale: Int = 0

    private lateinit var mTitle: String
    private var mTextColor: Int = 0
    private var mTextSize: Int = 0

    private var mTextBound: Rect
    private var mImageBound: Rect
    private var mPaint: Paint

    private var mWidth: Int = 0
    private var mHeight: Int = 0

    init {
        val typeArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomImageView, defStyleAttr, 0)
        for (i in 0 until typeArray.indexCount) {
            when (val attr = typeArray.getIndex(i)) {
                R.styleable.CustomImageView_image -> mImage = BitmapFactory.decodeResource(resources, typeArray.getResourceId(attr, 0))
                R.styleable.CustomImageView_imageScaleType -> mImageScale = typeArray.getInt(attr, 0)
                R.styleable.CustomImageView_titleText -> mTitle = typeArray.getString(attr).toString()
                R.styleable.CustomImageView_titleTextColor -> mTextColor = typeArray.getColor(attr, Color.BLACK)
                R.styleable.CustomImageView_titleTextSize -> {
                    val defaultSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16f, resources.displayMetrics)
                    mTextSize = typeArray.getDimensionPixelSize(attr, defaultSize.toInt())
                }
            }
        }
        typeArray.recycle()

        mImageBound = Rect()
        mTextBound = Rect()
        mPaint = Paint()
        mPaint.textSize = mTextSize.toFloat()
        mPaint.getTextBounds(mTitle, 0, mTitle.length, mTextBound)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)

        mWidth = if (widthMode == MeasureSpec.EXACTLY) {
            widthSize
        } else {
            val widthImg = paddingLeft + paddingRight + mImage.width
            val widthText = paddingLeft + paddingRight + mTextBound.width()
            if (widthMode == MeasureSpec.AT_MOST) {
                val desireWidth = max(widthImg, widthText)
                min(desireWidth, widthSize)
            } else {
                100
            }
        }

        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        mHeight = if (heightMode == MeasureSpec.EXACTLY) {
            heightSize
        } else {
            val desire = paddingBottom + paddingTop + mImage.height + mTextBound.height()
            if (heightMode == MeasureSpec.AT_MOST) {
                min(desire, heightSize)
            } else {
                100
            }
        }

        setMeasuredDimension(mWidth, mHeight)
    }

    override fun onDraw(canvas: Canvas) {
        mPaint.strokeWidth = 4f
        mPaint.style = Paint.Style.STROKE
        mPaint.color = Color.CYAN
        canvas.drawRect(0f, 0f, mWidth.toFloat(), mHeight.toFloat(), mPaint)

        mPaint.color = mTextColor
        mPaint.style = Paint.Style.FILL

        if (mTextBound.width() > mWidth) {
            val paint = TextPaint()
            val msg = TextUtils.ellipsize(mTitle, paint, (mWidth - paddingLeft - paddingRight).toFloat(), TextUtils.TruncateAt.END).toString()
            canvas.drawText(msg, paddingLeft.toFloat(), (mWidth - paddingBottom).toFloat(), mPaint)
        } else {
            canvas.drawText(mTitle, mWidth / 2 - mTextBound.width() * 1.0f / 2, (mHeight - paddingBottom).toFloat(), mPaint)
        }

        mImageBound.left = paddingLeft
        mImageBound.right = mWidth - paddingRight
        mImageBound.top = paddingTop
        mImageBound.bottom -= mTextBound.height()

        if (mImageScale == 0) {
            canvas.drawBitmap(mImage, null, mImageBound, mPaint)
        } else {
            //计算居中的矩形范围
            mImageBound.left = mWidth / 2 - mImage.width / 2
            mImageBound.right = mWidth / 2 + mImage.width / 2
            mImageBound.top = (mHeight - mTextBound.height()) / 2 - mImage.height / 2
            mImageBound.bottom = (mHeight - mTextBound.height()) / 2 + mImage.height / 2

            canvas.drawBitmap(mImage, null, mImageBound, mPaint)
        }
    }
}