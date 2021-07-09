package com.workbook.liuwb.workbook.actions.customview.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.workbook.liuwb.mylibrary.utils.MyUtils;

import java.util.ArrayList;
import java.util.List;

public class FlexedLayout extends ViewGroup {

    private int horizontalSpace = (int) MyUtils.dp2px(getContext(), 16f);
    private int verticalSpace = (int) MyUtils.dp2px(getContext(), 16f);

    private List<List<View>> allLineViews = new ArrayList<>();
    private List<Integer> allLineHeights = new ArrayList<>();

    public FlexedLayout(Context context) {
        super(context);
    }

    public FlexedLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlexedLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        allLineViews = new ArrayList<>();
        allLineHeights = new ArrayList<>();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        List<View> lineViews = new ArrayList<>();
        int lineWidthUsed = 0;
        int lineHeight = 0;

        int parentNeedWidth = 0;
        int parentNeedHeight = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            LayoutParams childParams = childView.getLayoutParams();
            int childWidthMeasureSpec = getChildMeasureSpec(widthMeasureSpec, getPaddingLeft() + getPaddingRight(), childParams.width);
            int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, getPaddingTop() + getPaddingBottom(), childParams.height);

            childView.measure(childWidthMeasureSpec, childHeightMeasureSpec);

            int childMeasureWidth = childView.getMeasuredWidth();
            int childMeasureHeight = childView.getMeasuredHeight();

            if (childMeasureWidth + lineWidthUsed + horizontalSpace > MeasureSpec.getSize(widthMeasureSpec)) {
                parentNeedWidth = Math.max(parentNeedWidth, lineWidthUsed + horizontalSpace);
                parentNeedHeight = parentNeedHeight + lineHeight + verticalSpace;

                allLineViews.add(lineViews);
                allLineHeights.add(lineHeight);

                lineViews = new ArrayList<>();
                lineWidthUsed = 0;
                lineHeight = 0;
            }

            lineViews.add(childView);
            lineWidthUsed = lineWidthUsed + childMeasureWidth + horizontalSpace;
            lineHeight = Math.max(lineHeight, childMeasureHeight);
        }

        int selfWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int selfHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        int realWidth = selfWidthMode == MeasureSpec.EXACTLY ? MeasureSpec.getSize(widthMeasureSpec) : parentNeedWidth;
        int realHeight = selfHeightMode == MeasureSpec.EXACTLY ? MeasureSpec.getSize(heightMeasureSpec) : parentNeedHeight;

        setMeasuredDimension(realWidth, realHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int currentLeft = getPaddingLeft();
        int currentTop = getPaddingTop();

        int lineCount = allLineViews.size();
        for (int i = 0; i < lineCount; i++) {
            List<View> lineViews = allLineViews.get(i);

            for (int k = 0; k < lineViews.size(); i++) {
                View view = lineViews.get(k);
                int left = currentLeft;
                int top = currentTop;
                int right = left + view.getMeasuredWidth();
                int bottom = top + view.getMeasuredHeight();
                view.layout(left, top, right, bottom);

                currentLeft = right + horizontalSpace;
            }
            currentTop = currentTop + allLineHeights.get(i) + verticalSpace;
        }
    }
}
