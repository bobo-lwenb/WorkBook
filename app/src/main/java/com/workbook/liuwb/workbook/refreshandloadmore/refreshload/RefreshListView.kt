package com.workbook.liuwb.workbook.refreshandloadmore.refreshload

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.RotateAnimation
import android.widget.AbsListView
import android.widget.AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL
import android.widget.ListView
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.header_layout_rl.view.*

/// 目前这种写法没有成功，似乎是错的
class RefreshListView : ListView, AbsListView.OnScrollListener {

    private val headerHeight: Int // 头部布局的高度
    private var firstVisibleItem: Int = 0 // 当前屏幕第一个可见item的位置
    private var isRemark: Boolean = false // 是否是在listview的顶部按下
    private var startY: Int = 0 // 按下式手指的Y值

    private var currScrollState: Int = -1

    private var currState: Int = -1 // 当前下拉的状态
    private val NORMAL: Int = 0 // 正常状态
    private val PULL: Int = 1 // 正在下拉状态
    private val RELESE: Int = 2 // 提示松开释放的状态
    private val REFRESHING: Int = 3 // 正在刷新状态

    private val headerView: View = LayoutInflater.from(context).inflate(R.layout.header_layout_rl, null) // 头部布局

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr)

    init {
        var params = headerView.layoutParams
        if (params == null) {
            params = LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        val width: Int = ViewGroup.getChildMeasureSpec(0, 0, params.width)
        val tempHeight: Int = params.height
        headerHeight = if (tempHeight > 0) {
            MeasureSpec.makeMeasureSpec(tempHeight, MeasureSpec.EXACTLY)
        } else {
            MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
        }
        headerView.measure(width, headerHeight)

        setViewTopPadding(-headerView.measuredHeight)

        addHeaderView(headerView)
        setOnScrollListener(this)
    }

    override fun onScroll(view: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
        this.firstVisibleItem = firstVisibleItem
    }

    override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
        currScrollState = scrollState
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        when (ev?.action) {
            MotionEvent.ACTION_DOWN -> {
                if (firstVisibleItem == 0) {
                    isRemark = true
                    startY = ev.y.toInt()
                    currState = NORMAL
                }
            }
            MotionEvent.ACTION_MOVE -> onMove(ev)
            MotionEvent.ACTION_UP -> {
                if (currState == RELESE) {
                    currState = REFRESHING
                } else if (currState == PULL) {
                    currState = NORMAL
                    isRemark = false
                    updateHeaderView()
                }
            }
        }
        return super.onTouchEvent(ev)
    }

    private fun onMove(ev: MotionEvent?) {
        if (!isRemark) return

        val tempY = ev!!.y.toInt()
        val offsetY = tempY - startY

        val topPadding = offsetY - headerHeight

        when (currState) {
            NORMAL -> {
                if (offsetY > 0) {
                    currState = PULL
                    updateHeaderView()
                }
            }
            PULL -> {
                setViewTopPadding(topPadding - headerHeight)
                if (offsetY > headerHeight + 50 && currScrollState == SCROLL_STATE_TOUCH_SCROLL) {
                    currState = RELESE
                    updateHeaderView()
                }
            }
            RELESE -> {
                setViewTopPadding(-headerHeight)
                if (offsetY < headerHeight + 50) {
                    currState = PULL
                    updateHeaderView()
                } else if (offsetY <= 0) {
                    currState = NORMAL
                    isRemark = false
                    updateHeaderView()
                }
            }
            REFRESHING -> {
            }
        }
    }

    private fun updateHeaderView() {

        val animation = RotateAnimation(0f, 180f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f)
        animation.duration = 500
        animation.fillAfter = true

        val animation1 = RotateAnimation(180f, 0f, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f)
        animation1.duration = 500
        animation1.fillAfter = true

        when (currState) {
            NORMAL -> {
                rl_image.clearAnimation()
                setViewTopPadding(-headerHeight)
            }
            PULL -> {
                rl_image.visibility = View.VISIBLE
                rl_pro.visibility = View.GONE
                rl_tip.text = "下拉可以刷新"

                rl_image.clearAnimation()
                rl_image.animation = animation1
            }
            RELESE -> {
                rl_image.visibility = View.VISIBLE
                rl_pro.visibility = View.GONE
                rl_tip.text = "松开可以刷新"

                rl_image.clearAnimation()
                rl_image.animation = animation
            }
            REFRESHING -> {
                setViewTopPadding(headerHeight)
                rl_image.clearAnimation()
                rl_image.visibility = View.GONE
                rl_pro.visibility = View.VISIBLE
                rl_tip.text = "正在刷新"
            }
        }
    }

    private fun setViewTopPadding(padding: Int) {
        headerView.setPadding(headerView.paddingLeft, padding, headerView.paddingRight, headerView.paddingBottom)
        headerView.invalidate()
    }

}