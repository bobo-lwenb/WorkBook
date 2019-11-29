package com.workbook.liuwb.workbook.service.bind.messenger

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.mylibrary.utils.Logger
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.WBConstants

class MessengerActivity : AppCompatActivity() {

    private val mGetReplyMessenger = Messenger(MessengerHandler())

    private val mConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            val mServerMessenger = Messenger(service)
            val message = Message.obtain(null, WBConstants.MSG_FROM_CLIENT)
            val bundle = Bundle()
            bundle.putString("msg", "hello,this is from client!")
            message.data = bundle
            message.replyTo = mGetReplyMessenger
            try {
                mServerMessenger.send(message)
            } catch (e: RemoteException) {
                e.printStackTrace()
            }

        }

        override fun onServiceDisconnected(name: ComponentName) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messenger)
        val intent = Intent(this, MessengerService::class.java)
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(mConnection)
    }

    private class MessengerHandler : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                WBConstants.MSG_FROM_SERVICE -> Logger.e(TAG + msg.data.getString("reply")!!)
                else -> super.handleMessage(msg)
            }
        }
    }

    companion object {
        private val TAG = "MessengerActivity"
    }
}
