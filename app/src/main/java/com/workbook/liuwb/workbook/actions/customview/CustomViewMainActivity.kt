package com.workbook.liuwb.workbook.actions.customview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.databinding.ActivityCustomviewMainBinding
import com.workbook.liuwb.workbook.actions.customview.view.CustomImageActivity
import com.workbook.liuwb.workbook.actions.customview.view.CustomProgressBarActivity
import com.workbook.liuwb.workbook.actions.customview.view.CustomTitleActivity
import com.workbook.liuwb.workbook.actions.customview.view.FollowFingerActivity
import com.workbook.liuwb.workbook.actions.customview.viewgroup.CarouselActivity
import com.workbook.liuwb.workbook.actions.customview.viewgroup.NoSlipViewPagerActivity
import com.workbook.liuwb.workbook.actions.customview.dialog.GeneralDialog
import com.workbook.liuwb.workbook.actions.customview.dialog.showDialog
import com.workbook.liuwb.workbook.actions.customview.viewgroup.MyScrollerActivity
import com.workbook.liuwb.workbook.actions.customview.gesture.VelocityTrackerActivity
import com.workbook.liuwb.workbook.actions.customview.gesture.GestureDetectorActivity
import com.workbook.liuwb.workbook.actions.customview.viewgroup.CustomContainerActivity
import com.workbook.liuwb.workbook.actions.customview.viewgroup.FlexedLayoutActivity

class CustomViewMainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityCustomviewMainBinding by lazy {
        ActivityCustomviewMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.customImage.setOnClickListener(this)
        binding.customProgressbar.setOnClickListener(this)
        binding.customTitle.setOnClickListener(this)
        binding.followFinger.setOnClickListener(this)
        binding.noSlipViewpager.setOnClickListener(this)
        binding.carouselView.setOnClickListener(this)
        binding.myScrollerView.setOnClickListener(this)
        binding.customContainer.setOnClickListener(this)
        binding.flexedLayout.setOnClickListener(this)
        binding.dialog1.setOnClickListener(this)
        binding.dialog2.setOnClickListener(this)
        binding.velocityTracker.setOnClickListener(this)
        binding.gestureDetector.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent: Intent = Intent()
        when (v.id) {
            // View
            R.id.custom_image -> {
                intent.setClass(this, CustomImageActivity::class.java)
                startActivity(intent)
            }
            R.id.custom_progressbar -> {
                intent.setClass(this, CustomProgressBarActivity::class.java)
                startActivity(intent)
            }
            R.id.custom_title -> {
                intent.setClass(this, CustomTitleActivity::class.java)
                startActivity(intent)
            }
            R.id.follow_finger -> {
                intent.setClass(this, FollowFingerActivity::class.java)
                startActivity(intent)
            }
            // ViewGroup
            R.id.no_slip_viewpager -> {
                intent.setClass(this, NoSlipViewPagerActivity::class.java)
                startActivity(intent)
            }
            R.id.carousel_view -> {
                intent.setClass(this, CarouselActivity::class.java)
                startActivity(intent)
            }
            R.id.my_scroller_view -> {
                intent.setClass(this, MyScrollerActivity::class.java)
                startActivity(intent)
            }
            R.id.custom_container -> {
                intent.setClass(this, CustomContainerActivity::class.java)
                startActivity(intent)
            }
            R.id.flexed_layout -> {
                intent.setClass(this, FlexedLayoutActivity::class.java)
                startActivity(intent)
            }
            // Dialog
            R.id.dialog_1 -> {
                showDialog(
                    this,
                    "11111",
                    "adafsfgfgdg",
                    "cancel",
                    "ok",
                    {
                        Toast.makeText(this, "left", Toast.LENGTH_SHORT).show()
                    },
                    {
                        Toast.makeText(this, "right", Toast.LENGTH_SHORT).show()
                    }
                )
            }
            R.id.dialog_2 -> {
                GeneralDialog.Builder(this)
                    .setContentView(R.layout.dialog_general)
                    .setText(R.id.title, "notice!!")
                    .setText(R.id.content, "hfehvighibhgtribrgbvglfbjfgbjfgb")
                    .setText(R.id.left, "cancel")
                    .setCLickListener(R.id.left) { dialog, _ ->
                        dialog.dismiss()
                    }
                    .setText(R.id.right, "OK")
                    .setCLickListener(R.id.right) { dialog, _ ->
                        dialog.dismiss()
                    }
                    .build()
                    .show(supportFragmentManager, "su")
            }
            // Gesture
            R.id.velocity_tracker -> {
                intent.setClass(this, VelocityTrackerActivity::class.java)
                startActivity(intent)
            }
            R.id.gesture_detector -> {
                intent.setClass(this, GestureDetectorActivity::class.java)
                startActivity(intent)
            }
        }

    }
}