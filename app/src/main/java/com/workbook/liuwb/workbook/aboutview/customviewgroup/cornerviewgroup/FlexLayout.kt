package com.workbook.liuwb.workbook.aboutview.customviewgroup.cornerviewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.workbook.liuwb.mylibrary.utils.MyUtils
import kotlin.math.max

class FlexLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ViewGroup(context, attrs, defStyleAttr) {

    private val horizontalSpace = MyUtils.dp2px(context, 16f)
    private val verticalSpace = MyUtils.dp2px(context, 16f)

    private val allLineViews = arrayListOf<List<View>>()
    private val allLineHeights = arrayListOf<Int>()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        // 存放一行的view，view是分行layout的，所以要记录每一行的view
        // 方便在onLayout的时候布局
        var lineViews = arrayListOf<View>()

        // 记录一行所用的宽度
        var lineWidthUsed = 0

        // 记录一行的最大高
        var lineHeight = 0

        // 测量过程中父view需要的最大宽高
        var parentNeedWidth = 0
        var parentHeight = 0

        // 测量所有子view的宽高
        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            val childParams = childView.layoutParams
            val childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, childParams.width)
            val childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, childParams.height)

            childView.measure(childWidthMeasureSpec, childHeightMeasureSpec)

            // 获取子view的宽高
            val childMeasureWidth = childView.measuredWidth
            val childMeasureHeight = childView.measuredHeight

            if (childMeasureWidth + lineWidthUsed + horizontalSpace > MeasureSpec.getSize(widthMeasureSpec)) {
                parentNeedWidth = max(parentNeedWidth, lineWidthUsed + horizontalSpace.toInt())
                parentHeight += lineHeight + verticalSpace.toInt()

                allLineViews.add(lineViews)
                allLineHeights.add(lineHeight)

                lineViews = arrayListOf()

                lineWidthUsed = 0
                lineHeight = 0
            }

            lineViews.add(childView)
            lineWidthUsed += childMeasureWidth + horizontalSpace.toInt()
            lineHeight = max(lineHeight, childMeasureHeight)
        }

        // 测量自身的宽高
        val realWidth = if (MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.EXACTLY) MeasureSpec.getSize(widthMeasureSpec) else parentNeedWidth
        val realHeight = if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.EXACTLY) MeasureSpec.getSize(heightMeasureSpec) else parentHeight
        setMeasuredDimension(realWidth, realHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

        var currentLeft = paddingLeft
        var currentTop = paddingTop

        for (i in 0 until allLineViews.size) {
            val lineViews = allLineViews[i]
            for (element in lineViews) {
                val left = currentLeft
                val top = currentTop
                val right = currentLeft + element.measuredWidth
                val bottom = currentTop + element.measuredHeight
                element.layout(left, top, right, bottom)

                currentLeft = right + horizontalSpace.toInt()
            }
            currentLeft = paddingLeft
            currentTop += allLineHeights[i] + verticalSpace.toInt()
        }
    }
}