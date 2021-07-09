package com.workbook.liuwb.workbook.actions.customview.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.Scroller
import com.workbook.liuwb.mylibrary.utils.Logger

/**
 * 在自定义ViewGroup中，必须要实现的步骤（方法）有：测量--》布局--》绘制
 * 绘制过程：对于自定义ViewGroup的绘制，其实就是子视图的绘制过程，只需要让子视图自行绘制即可
 * 也就是说，对于ViewGroup的绘制过程不需要重写绘制的方法
 */
class CarouselView : ViewGroup {

    private var childViews: Int = 0// 子视图个数
    private var childWidth: Int = 0// 子视图宽度
    private var childHeight: Int = 0// 子视图高度

    private var x: Int = 0
    private var startX: Int = 0// 按下时的横坐标
    private var index = 0// 图片索引

    private var scroller: Scroller? = null

    constructor(context: Context) : super(context) {
        initObj()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initObj()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initObj()
    }

    private fun initObj() {
        scroller = Scroller(context)
    }

    override fun computeScroll() {
        super.computeScroll()
        if (scroller!!.computeScrollOffset()) {
            scrollTo(scroller!!.currX, 0)
            invalidate()
        }
    }

    /**
     * 对于测量来说就是onMeasure
     * 由于要实现的是一个基于ViewGroup的容器，所以想要测量这个ViewGroup的宽高，那么就必须先去测量所有子视图的
     * 宽高之和，才能知道这个ViewGroup的宽高是多少
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        // 1、求出子视图的个数
        childViews = childCount
        if (0 == childViews) {
            setMeasuredDimension(0, 0)
        } else {
            // 2、测量子视图的宽高
            measureChildren(widthMeasureSpec, heightMeasureSpec)
            //此时就能够知道，该ViewGroup的高度就是第一个子视图的高度，宽度就是第一个子视图的宽度 * 子视图的个数
            val view = getChildAt(0)
            // 3、根据子视图的宽高来求出该ViewGroup的宽高
            childWidth = view.measuredWidth
            childHeight = view.measuredHeight

            val width = childWidth * childViews
            val height = childHeight
            setMeasuredDimension(width, height)
        }
    }

    /**
     * 对于布局来说就是onLayout
     * 继承自ViewGroup必须实现onLayout方法
     *
     * @param changed 当ViewGroup布局位置发生改变的时候为true
     * @param l
     * @param t
     * @param r
     * @param b
     */
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        if (changed) {
            var leftMargin = 0
            for (i in 0 until childViews) {
                val view = getChildAt(i)
                view.layout(leftMargin, 0, leftMargin + childWidth, childHeight)
                leftMargin += childWidth
            }
        }
    }

    /**
     * 事件传递过程中调用的方法：
     * 需要调用容器的事件拦截方法onInterceptTouchEvent
     * 对于该ViewGroup，是希望接受该事件的
     *
     * @param ev
     * @return true：容器拦截此次事件，事件停止传递。false：容器不拦截此次事件，事件继续向下传递
     */
//    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
//        return true
//    }

    /**
     * 真正处理点击事件的方法
     *
     *
     * 用两中方式实现轮播
     * 1、利用scrollTo、scrollBy实现手动轮播
     * 2、利用Scroller类实现自动轮播
     *
     * @param event
     * @return true:告诉该ViewGroup的父容器以已经处理好了该事件
     */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (!scroller!!.isFinished) {
                    scroller!!.abortAnimation()
                }
                x = event.x.toInt()
                startX = x
            }
            MotionEvent.ACTION_MOVE -> {
                val moveX = event.x.toInt()
                val distance = moveX - x
                scrollBy(-distance, 0)
                x = moveX
            }
            MotionEvent.ACTION_UP -> {
                val scrollX = scrollX // scrollX/scrollY代表试图总共已滑动过的距离
                Logger.e("  CarouselViewGroup ACTION_UP 111222 $scrollX")
                val tempX = (startX - event.x).toInt()
                if (Math.abs(tempX) >= childWidth * 0.15) {
                    if (tempX > 0) {
                        index++
                    } else {
                        index--
                    }
                }
                if (index < 0) {// 说明滑动到了最左边
                    index = 0
                } else if (index > childViews - 1) {// 说明滑动到了最右边
                    index = childViews - 1
                }
                //                scrollTo/scrollBy的方式
                //                scrollTo(index * childWidth, 0);

                //                Scroller的方式
                val dx = index * childWidth - scrollX
                scroller!!.startScroll(scrollX, 0, dx, 0, 300)
                postInvalidate()
            }
            else -> {
            }
        }
        return true
    }

    override fun performClick(): Boolean {
        invalidate()
        requestLayout()
        requestFocus()
        return super.performClick()
    }
}
