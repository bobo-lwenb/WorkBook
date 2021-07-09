package com.workbook.liuwb.workbook.actions.customview.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import kotlin.math.max


class CustomContainer @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        /**
         * 获得此ViewGroup上级容器为其推荐的宽和高，以及计算模式
         */
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)

        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        /**
         * 测量所有子view的宽高，内部调用了measureChild()方法
         */
        measureChildren(widthMeasureSpec, heightMeasureSpec)

        var childWidth: Int
        var childHeight: Int

        // 用于计算左边两个childView的高度
        var leftHeight = 0
        // 用于计算右边两个childView的高度，最终高度取二者之间大值
        var rightHeight = 0

        // 用于计算上边两个childView的宽度
        var topWidth = 0
        // 用于计算上边两个childView的宽度，最终宽度取二者之间大值
        var bottomWidth = 0

        var childParams: MarginLayoutParams

        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            childWidth = childView.measuredWidth
            childHeight = childView.measuredHeight
            childParams = childView.layoutParams as MarginLayoutParams

            if (i == 0 || i == 1) {
                topWidth += childWidth + childParams.leftMargin + childParams.rightMargin
            }
            if (i == 2 || i == 3) {
                bottomWidth += childWidth + childParams.leftMargin + childParams.rightMargin
            }
            if (i == 0 || i == 2) {
                leftHeight += childHeight + childParams.topMargin + childParams.bottomMargin
            }
            if (i == 1 || i == 3) {
                rightHeight += childHeight + childParams.topMargin + childParams.bottomMargin
            }

            /**
             * 根据测量模式确定宽高
             */
            val width = if (widthMode == MeasureSpec.EXACTLY) {
                widthSize
            } else {
                max(topWidth, bottomWidth)
            }

            val height = if (heightMode == MeasureSpec.EXACTLY) {
                heightSize
            } else {
                max(leftHeight, rightHeight)
            }

            setMeasuredDimension(width, height)
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var childWidth: Int
        var childHeight: Int
        var childParams: MarginLayoutParams

        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            childWidth = childView.measuredWidth
            childHeight = childView.measuredHeight
            childParams = childView.layoutParams as MarginLayoutParams

            var childLeft = 0
            var childTop = 0
            var childRight: Int
            var childBottom: Int

            /**
             * 计算子view左上右下角的坐标
             */
            when (i) {
                0 -> {
                    childLeft = childParams.leftMargin
                    childTop = childParams.topMargin
                }
                1 -> {
                    childLeft = width - childWidth - childParams.rightMargin
                    childTop = childParams.topMargin
                }
                2 -> {
                    childLeft = childParams.leftMargin
                    childTop = height - childHeight - childParams.bottomMargin
                }
                3 -> {
                    childLeft = width - childWidth - childParams.rightMargin
                    childTop = height - childHeight - childParams.bottomMargin
                }
            }
            childRight = childLeft + childWidth
            childBottom = childTop + childHeight

            childView.layout(childLeft, childTop, childRight, childBottom)
        }
    }
}