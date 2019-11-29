package com.workbook.liuwb.workbook.handler

import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.R

class HandlerThreadActivity : AppCompatActivity() {

    private lateinit var mHandlerThread: HandlerThread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handlerthread)

        // 1、创建HandlerThread
        mHandlerThread = HandlerThread("mHandlerThread")
        // 2、开启HandlerThread
        mHandlerThread.start()

        // 3、创建HandlerThread的Handler，并复写其handleMessage方法
        val handler = object : Handler(mHandlerThread.looper) {
            override fun handleMessage(msg: Message) {
                when (msg.what) {
                    1 -> {

                    }
                    2 -> {

                    }
                }
            }
        }

        // 4、通过Handler发送消息
        val message = Message.obtain()
        message.what = 1
        message.arg1 = 1111
        handler.sendMessage(message)
    }

    override fun onDestroy() {
        super.onDestroy()
        // 5、使用完退出HandlerThread
        mHandlerThread.quit()
    }
}