package com.workbook.liuwb.workbook.actions.animation.propertyanimation.evaluator

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyAnimView : View {

    private val RADIUS = 100f
    private var cPoint = Point(RADIUS, RADIUS)
    private var isFirst = true
    private var mCPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mTPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        mCPaint.color = Color.BLUE
        mTPaint.color = Color.WHITE
        mTPaint.textSize = 30f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(cPoint.x, cPoint.y, RADIUS, mCPaint)
        canvas.drawText("${cPoint.x}-${cPoint.y}", cPoint.x - RADIUS / 2, cPoint.y - RADIUS / 2, mTPaint)
        if (isFirst) {
            isFirst = false
            startAnimation()
        }
    }

    private fun startAnimation() {
        val startPoint = Point(RADIUS, RADIUS)
        val endPoint = Point(width - RADIUS, height - RADIUS)

        val valueAnimator = ValueAnimator.ofObject(PointEvaluator(), startPoint, endPoint)
        valueAnimator.addUpdateListener { animation ->
            cPoint = animation.animatedValue as Point
            invalidate()
        }
        valueAnimator.duration = 5000
        valueAnimator.start()
    }
}