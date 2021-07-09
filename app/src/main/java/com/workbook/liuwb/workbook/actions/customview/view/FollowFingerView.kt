package com.workbook.liuwb.workbook.actions.customview.view

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration

import com.workbook.liuwb.mylibrary.utils.Logger

class FollowFingerView : View {

    private val touchSlop = ViewConfiguration.get(context).scaledTouchSlop
    private var mLastX: Int = 0
    private var mLastRawX: Int = 0
    private var mLastY: Int = 0
    private var mLastRawY: Int = 0

    private var rectLocal = Rect()
    private var rectGlobal = Rect()

    private var windowArray = IntArray(2)
    private var screenArray = IntArray(2)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x.toInt()
        val y = event.y.toInt()
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mLastX = x
                mLastY = y
                mLastRawX = event.rawX.toInt()
                mLastRawY = event.rawY.toInt()
                Logger.e("  FollowFingerView ACTION_DOWN 111222 $mLastRawX $mLastRawY")
                return super.onTouchEvent(event)
            }
            MotionEvent.ACTION_MOVE -> {
                val deltaX = x - mLastX
                val deltaY = y - mLastY
                Logger.e("  FollowFingerView ACTION_MOVE $deltaX $deltaY")
                val translationX = (translationX + deltaX).toInt()
                val translationY = (translationY + deltaY).toInt()
                setTranslationX(translationX.toFloat())
                setTranslationY(translationY.toFloat())
//                offsetLeftAndRight(translationX)
//                offsetTopAndBottom(translationY)

                getGlobalVisibleRect(rectGlobal)
                Logger.e("  FollowFingerView getGlobalVisibleRect $rectGlobal")

                getLocalVisibleRect(rectLocal)
                Logger.e("  FollowFingerView getLocalVisibleRect $rectLocal")

                getLocationInWindow(windowArray)
                Logger.e("  FollowFingerView getLocationInWindow ${windowArray[0]}===${windowArray[1]}")

                getLocationOnScreen(screenArray)
                Logger.e("  FollowFingerView getLocationOnScreen ${screenArray[0]}===${screenArray[1]}")
            }
            MotionEvent.ACTION_UP -> {
                Logger.e("  FollowFingerView ACTION_UP 111222 " + event.rawX.toInt() + " " + event.rawY.toInt())
                val dx = event.rawX.toInt() - mLastRawX
                val dy = event.rawY.toInt() - mLastRawY
                if (Math.abs(dx) < touchSlop && Math.abs(dy) < touchSlop) {
                    return super.onTouchEvent(event)
                }
            }
            else -> {
            }
        }
        return true
    }

}
