package com.workbook.liuwb.workbook.actions.animation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.actions.animation.propertyanimation.LayoutAnimationsActivity
import com.workbook.liuwb.workbook.actions.animation.propertyanimation.evaluator.PointEvaluatorActivity
import com.workbook.liuwb.workbook.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityAnimationBinding by lazy {
        ActivityAnimationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.layoutAnimation.setOnClickListener(this)
        binding.typeEvaluator.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent: Intent
        when (v.id) {
            R.id.layout_animation -> {
                intent = Intent(this, LayoutAnimationsActivity::class.java)
                startActivity(intent)
            }
            R.id.type_evaluator -> {
                intent = Intent(this, PointEvaluatorActivity::class.java)
                startActivity(intent)
            }
        }
    }
}