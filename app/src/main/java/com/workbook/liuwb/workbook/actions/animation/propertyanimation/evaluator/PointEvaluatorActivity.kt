package com.workbook.liuwb.workbook.actions.animation.propertyanimation.evaluator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityPointevaluatorBinding

class PointEvaluatorActivity : AppCompatActivity() {

    private val binding: ActivityPointevaluatorBinding by lazy {
        ActivityPointevaluatorBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}