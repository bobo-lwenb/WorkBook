package com.workbook.liuwb.workbook.aboutview.gesturedetector

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.*
import com.workbook.liuwb.mylibrary.utils.Logger

class GestureDetectorView : View {

    private val colors = listOf(Color.BLUE, Color.LTGRAY, Color.RED, Color.CYAN, Color.YELLOW)

    private val gestureDetector: GestureDetector = GestureDetector(context, object : GestureDetector.OnGestureListener {
        override fun onShowPress(p0: MotionEvent?) {
            Logger.e("GestureDetectorView: onShowPress")
        }

        override fun onSingleTapUp(p0: MotionEvent?): Boolean {
            Logger.e("GestureDetectorView: onSingleTapUp")
            return true
        }

        override fun onDown(p0: MotionEvent?): Boolean {
            Logger.e("GestureDetectorView: onDown")
            return true
        }

        override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
            Logger.e("GestureDetectorView: onFling")
            return true
        }

        override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
            Logger.e("GestureDetectorView: onScroll")
            return true
        }

        override fun onLongPress(p0: MotionEvent?) {
            Logger.e("GestureDetectorView: onLongPress")
        }
    })

    private val imgs = listOf<View>()

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        gestureDetector.setOnDoubleTapListener(object : GestureDetector.OnDoubleTapListener {
            override fun onDoubleTap(p0: MotionEvent?): Boolean {
                Logger.e("GestureDetectorView: onDoubleTap")
                return true
            }

            override fun onDoubleTapEvent(p0: MotionEvent?): Boolean {
                Logger.e("GestureDetectorView: onDoubleTapEvent")
                return true
            }

            override fun onSingleTapConfirmed(p0: MotionEvent?): Boolean {
                Logger.e("GestureDetectorView: onSingleTapConfirmed")
                return true
            }
        })
        setBackgroundColor(Color.RED)
//        setOnTouchListener(this)
//        for (i in 0..5) {
//            val view = View(context)
//            val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
//            view.layoutParams = params
//            view.setBackgroundColor(colors[i])
//            addView(view)
//        }
    }

    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event)
    }
}