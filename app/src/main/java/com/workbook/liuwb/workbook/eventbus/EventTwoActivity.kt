package com.workbook.liuwb.workbook.eventbus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class EventTwoActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_two)
        EventBus.getDefault().postSticky(BasicEvent.builder().code(11).build())
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: BasicEvent) {
    }
}