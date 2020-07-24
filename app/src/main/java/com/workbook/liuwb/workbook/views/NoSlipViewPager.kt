package com.workbook.liuwb.workbook.views

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * 不可以左右滑动的ViewPager
 */
class NoSlipViewPager : ViewPager {

    var isNoSlip = true

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    override fun onInterceptHoverEvent(event: MotionEvent): Boolean {
        return if (isNoSlip) {
            false
        } else {
            super.onInterceptHoverEvent(event)
        }
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return if (isNoSlip) {
            super.onTouchEvent(ev)
        } else {
            true
        }
    }

    override fun setCurrentItem(item: Int) {
        super.setCurrentItem(item, !isNoSlip)
    }
}
