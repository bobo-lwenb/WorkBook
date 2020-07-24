package com.workbook.liuwb.workbook.memory

import android.content.ComponentCallbacks
import android.content.ComponentCallbacks2
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.os.Debug
import android.os.Handler
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R

class Memory1Activity : AppCompatActivity() {

    private val mHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            repeat(100) {
                //创建内存抖动
                val data = arrayOfNulls<String>(100000)
            }
            sendEmptyMessageDelayed(0, 30)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory1)
//        Debug.startMethodTracing("demo")
        runLeakTread()
//        Debug.stopMethodTracing()
    }

    override fun onDestroy() {
        super.onDestroy()
        mHandler.removeCallbacksAndMessages(null)
    }

    private fun memoryShake() {
        mHandler.sendEmptyMessage(1)
    }

    private fun runLeakTread() {
        val leak = LeakThread()
        leak.start()
    }

    inner class LeakThread : Thread() {
        override fun run() {
            super.run()
            val manager = TestManager.getInstanceSafe(this@Memory1Activity)
            sleep(6 * 1000)
            manager.show()
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }
}



class Callback2 :ComponentCallbacks2 {
    override fun onLowMemory() {
        TODO("Not yet implemented")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        TODO("Not yet implemented")
    }

    override fun onTrimMemory(level: Int) {
        TODO("Not yet implemented")
    }

}