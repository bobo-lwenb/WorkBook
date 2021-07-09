package com.workbook.liuwb.workbook.actions.animation.propertyanimation

import android.animation.LayoutTransition
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityLayoutAnimationsBinding
import kotlin.math.min

class LayoutAnimationsActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private val binding: ActivityLayoutAnimationsBinding by lazy {
        ActivityLayoutAnimationsBinding.inflate(layoutInflater)
    }

    private lateinit var mGridLayout: GridLayout
    private var mVal: Int = 0
    private lateinit var mTransition: LayoutTransition


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.idAdd.setOnClickListener(this)
        binding.idAppear.setOnCheckedChangeListener(this)
        binding.idChangeAppear.setOnCheckedChangeListener(this)
        binding.idDisappear.setOnCheckedChangeListener(this)
        binding.idChangeDisappear.setOnCheckedChangeListener(this)

        mGridLayout = GridLayout(this)
        mGridLayout.columnCount = 5
        binding.idContainer.addView(mGridLayout)

        mTransition = LayoutTransition()
        mGridLayout.layoutTransition = mTransition
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        mTransition = LayoutTransition()
        mTransition.setAnimator(
            LayoutTransition.APPEARING,
            if (binding.idAppear.isChecked) mTransition.getAnimator(LayoutTransition.APPEARING) else null
        )
        mTransition.setAnimator(
            LayoutTransition.CHANGE_APPEARING,
            if (binding.idChangeAppear.isChecked) mTransition.getAnimator(LayoutTransition.CHANGE_APPEARING) else null
        )
        mTransition.setAnimator(
            LayoutTransition.DISAPPEARING,
            if (binding.idDisappear.isChecked) mTransition.getAnimator(LayoutTransition.DISAPPEARING) else null
        )
        mTransition.setAnimator(
            LayoutTransition.CHANGE_DISAPPEARING,
            if (binding.idChangeDisappear.isChecked) mTransition.getAnimator(LayoutTransition.CHANGE_DISAPPEARING) else null
        )
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