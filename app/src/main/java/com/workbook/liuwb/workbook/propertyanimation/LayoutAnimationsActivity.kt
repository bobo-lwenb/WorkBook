package com.workbook.liuwb.workbook.propertyanimation

import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import kotlinx.android.synthetic.main.activity_layout_nimations.*
import kotlin.math.min

class LayoutAnimationsActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private lateinit var mGridLayout: GridLayout
    private var mVal: Int = 0
    private lateinit var mTransition: LayoutTransition


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_nimations)

        id_add.setOnClickListener(this)
        id_appear.setOnCheckedChangeListener(this)
        id_change_appear.setOnCheckedChangeListener(this)
        id_disappear.setOnCheckedChangeListener(this)
        id_change_disappear.setOnCheckedChangeListener(this)

        mGridLayout = GridLayout(this)
        mGridLayout.columnCount = 5
        id_container.addView(mGridLayout)

        mTransition = LayoutTransition()
        mGridLayout.layoutTransition = mTransition
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        mTransition = LayoutTransition()
        mTransition.setAnimator(LayoutTransition.APPEARING, if (id_appear.isChecked) mTransition.getAnimator(LayoutTransition.APPEARING) else null)
        mTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, if (id_change_appear.isChecked) mTransition.getAnimator(LayoutTransition.CHANGE_APPEARING) else null)
        mTransition.setAnimator(LayoutTransition.DISAPPEARING, if (id_disappear.isChecked) mTransition.getAnimator(LayoutTransition.DISAPPEARING) else null)
        mTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, if (id_change_disappear.isChecked) mTransition.getAnimator(LayoutTransition.CHANGE_DISAPPEARING) else null)
        mGridLayout.layoutTransition = mTransition

    }

    override fun onClick(v: View?) {
        val btn = Button(this)
        btn.text = "${++mVal}"
        mGridLayout.addView(btn, min(1, mGridLayout.childCount))
        btn.setOnClickListener {
            mGridLayout.removeView(btn)
        }
    }
}