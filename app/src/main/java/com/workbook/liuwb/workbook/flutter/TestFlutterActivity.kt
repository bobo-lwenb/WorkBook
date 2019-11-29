package com.workbook.liuwb.workbook.flutter

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.workbook.liuwb.workbook.R
import io.flutter.facade.Flutter
import kotlinx.android.synthetic.main.activity_test_flutter.*

class TestFlutterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_flutter)

        test_demo.setOnClickListener {
//            addFlutterFragemnt()
            addFlutterView()
        }
    }

    private fun addFlutterFragemnt() {
        val transition: FragmentTransaction = supportFragmentManager.beginTransaction()
        transition.replace(R.id.test_content, Flutter.createFragment("route1"))
        transition.commit()
    }

    private fun addFlutterView() {
        val flutterView: View = Flutter.createView(this@TestFlutterActivity, lifecycle, "route1")
        val params = FrameLayout.LayoutParams(600, 800)
        params.leftMargin = 100
        params.topMargin = 200

        addContentView(flutterView, params)
    }
}