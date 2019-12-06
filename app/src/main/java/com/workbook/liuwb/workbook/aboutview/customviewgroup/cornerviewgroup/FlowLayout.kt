package com.workbook.liuwb.workbook.aboutview.customviewgroup.cornerviewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import kotlin.math.max

class FlowLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        /**
         * 获得它的父容器为它设置的测量模式和大小
         */
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)

        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        /**
         * 在WRAP_CONTENT下的宽高
         */
        var width = 0
        var height = 0

        var lineWidth = 0
        var lineHeight = 0

        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            /**
             *
             */
            measureChild(childView, widthMeasureSpec, heightMeasureSpec)
            val childParams: MarginLayoutParams = childView.layoutParams as MarginLayoutParams
            val childWidth = childView.measuredWidth + childParams.leftMargin + childParams.rightMargin
            val childHeight = childView.measuredHeight + childParams.topMargin + childParams.bottomMargin

            /**
             * 如果加入当前child，则超出最大宽度，则的到目前最大宽度给width，类加height 然后开启新行
             */
            if (lineWidth + childWidth > widthSize) {
                // 某一个childView是有可能比当前行宽的，所以要取最大值
                width = max(lineWidth, childWidth) // 设置当前行宽
                lineWidth = childWidth // 重新开启新行，开始记录

                height += lineHeight // 换行就需要叠加当前高度
                lineHeight = childHeight // 开启记录下一行的高度
            } else {
                // 否则累加值lineWidth,lineHeight取最大高度
                lineWidth += childWidth
                // 某一个childView是有可能比所有行高的，所以要取最大值
                lineHeight = max(lineHeight, childHeight)
            }
            // 如果是最后一个，则将当前记录的最大宽度和当前lineWidth做比较
            // 因为最后一个childView加入还没有换行，有可能宽已比width大
            // 还需将未换的行的行高加入lineHeight
            if (i == childCount - 1) {
                width = max(width, lineWidth)
                height += lineHeight
            }

            val desireWidth = if (widthMode == MeasureSpec.EXACTLY) {
                widthSize
            } else {
                width
            }
            val desireHeight = if (heightMode == MeasureSpec.EXACTLY) {
                heightSize
            } else {
                height
            }

            setMeasuredDimension(desireWidth, desireHeight)
        }
    }

    /**
     * 存储所有的View，按行记录
     */
    private val mAllViews = arrayListOf<List<View>>()
    /**
     * 记录每一行的最大高度
     */
    private val mLineHeight = arrayListOf<Int>()

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

        mAllViews.clear()
        mLineHeight.clear()

        val width = width

        var lineWidth = 0
        var lineHeight = 0
        // 存储每一行所有的childView
        var lineViews = arrayListOf<View>()
        // 遍历所有的孩子
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val lp: MarginLayoutParams = child.layoutParams as MarginLayoutParams
            val childWidth = child.measuredWidth
            val childHeight = child.measuredHeight

            // 如果已经需要换行
            if (childWidth + lp.leftMargin + lp.rightMargin + lineWidth > width) {
                // 记录这一行所有的View以及最大高度
                mLineHeight.add(lineHeight)
                // 将当前行的childView保存，然后开启新的ArrayList保存下一行的childView
                mAllViews.add(lineViews)
                lineWidth = 0// 重置行宽
                lineViews = arrayListOf()
            }
            /**
             * 如果不需要换行，则累加
             */
            lineWidth += childWidth + lp.leftMargin + lp.rightMargin
            lineHeight = max(lineHeight, childHeight + lp.topMargin + lp.bottomMargin)
            lineViews.add(child)
        }
        // 记录最后一行
        mLineHeight.add(lineHeight)
        mAllViews.add(lineViews)

        var left = 0
        var top = 0
        // 得到总行数
        val lineNums = mAllViews.size
        for (i in 0 until lineNums) {
            // 每一行的所有的views
            lineViews = mAllViews[i] as ArrayList<View>
            // 当前行的最大高度
            lineHeight = mLineHeight[i]

            // 遍历当前行所有的View
            for (j in 0 until lineViews.size) {
                val child = lineViews[j]
                if (child.visibility == View.GONE) {
                    continue
                }
                val lp = child.layoutParams as MarginLayoutParams

                //计算childView的left,top,right,bottom
                val lc = left + lp.leftMargin
                val tc = top + lp.topMargin
                val rc = lc + child.measuredWidth
                val bc = tc + child.measuredHeight

                child.layout(lc, tc, rc, bc)

                left += child.measuredWidth + lp.rightMargin + lp.leftMargin
            }
            left = 0
            top += lineHeight
        }

    }
}