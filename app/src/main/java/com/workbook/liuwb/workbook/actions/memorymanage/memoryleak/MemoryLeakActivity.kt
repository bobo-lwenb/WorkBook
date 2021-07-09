package com.workbook.liuwb.workbook.actions.memorymanage.memoryleak

import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityMemoryleakBinding

class MemoryLeakActivity : AppCompatActivity() {

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

    private val binding: ActivityMemoryleakBinding by lazy {
        ActivityMemoryleakBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
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
            val manager = TestManager.getInstanceSafe(this@MemoryLeakActivity)
            sleep(6 * 1000)
            manager.show()
        }
    }
}
