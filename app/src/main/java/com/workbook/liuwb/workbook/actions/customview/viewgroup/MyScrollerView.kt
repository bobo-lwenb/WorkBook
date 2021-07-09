package com.workbook.liuwb.workbook.actions.customview.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.*
import android.widget.Scroller
import com.workbook.liuwb.mylibrary.utils.Logger
import kotlin.math.abs

class MyScrollerView(context: Context, attrs: AttributeSet) : ViewGroup(context, attrs) {

    /**
     * // 第一步，创建Scroller的实例,用于完成滚动操作的实例
     */
    private val mScroller: Scroller = Scroller(context)

    /**
     * 判定为拖动的最小移动像素数
     */
    private val mTouchSlop: Int = ViewConfiguration.get(context).scaledTouchSlop

    /**
     * 手指按下时的屏幕坐标
     */
    private var mXDown: Float = 0.toFloat()

    /**
     * 手指当时所处的屏幕坐标
     */
    private var mXMove: Float = 0.toFloat()

    /**
     * 上次触发ACTION_MOVE事件时的屏幕坐标
     */
    private var mXLastMove: Float = 0.toFloat()

    /**
     * 界面可滚动的左边界
     */
    private var leftBorder: Int = 0

    /**
     * 界面可滚动的右边界
     */
    private var rightBorder: Int = 0

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        for (i: Int in 0 until childCount) {
            val childView = getChildAt(i)
            measureChild(childView, widthMeasureSpec, heightMeasureSpec)
        }

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        if (changed) {
            val childWidth = getChildAt(0).measuredWidth
            val childHeight = getChildAt(0).measuredHeight
            for (i: Int in 0 until childCount) {
                val childView = getChildAt(i)
                childView.layout(i * childWidth, 0, (i + 1) * childWidth, childHeight)
            }
        }
        leftBorder = getChildAt(0).left
        rightBorder = getChildAt(childCount - 1).right
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                Logger.e("MyScrollerView: onInterceptTouchEvent ACTION_DOWN")
                mXDown = ev.rawX
                mXLastMove = ev.rawX
            }
            MotionEvent.ACTION_MOVE -> {
                Logger.e("MyScrollerView: onInterceptTouchEvent ACTION_MOVE")
                mXMove = ev.rawX
                mXLastMove = ev.rawX
                val diff = abs(mXMove - mXDown)
                if (diff > mTouchSlop) {
                    return true
                }
            }
        }
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_MOVE -> {
                Logger.e("MyScrollerView: onTouchEvent ACTION_MOVE")
                mXMove = event.rawX
                val scrolledX = (mXLastMove - mXMove).toInt()
                if (scrollX + scrolledX < leftBorder) {
                    scrollTo(leftBorder, 0)
                    return true
                } else if (scrollX + width + scrolledX > rightBorder) {
                    scrollTo(rightBorder - width, 0)
                    return true
                }
                scrollBy(scrolledX, 0)
                mXLastMove = mXMove
            }
            MotionEvent.ACTION_UP -> {
                Logger.e("MyScrollerView: onTouchEvent ACTION_UP")
                // 当手指抬起时，根据当前的滚动值来计算以滚动到的子视图的下标
                val targetIndex = (scrollX + width / 2) / width

                val dx = targetIndex * width - scrollX
                // 第二步，调用startScroll()方法来初始化滚动数据并刷新界面
                mScroller.startScroll(scrollX, 0, dx, 0)
                invalidate()
            }
        }
        return true
    }

    override fun computeScroll() {
        // 第三步，重写computeScroll()方法，并在其内部完成平滑滚动的逻辑
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.currX, mScroller.currY)
            invalidate()
        }
    }

}