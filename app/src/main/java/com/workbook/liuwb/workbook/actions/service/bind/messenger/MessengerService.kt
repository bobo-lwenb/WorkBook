package com.workbook.liuwb.workbook.actions.service.bind.messenger

import android.app.Service
import android.content.Intent
import android.os.*
import com.workbook.liuwb.mylibrary.utils.Logger

class MessengerService : Service() {

    private val mMessenger = Messenger(MessengerHandler())

    override fun onBind(intent: Intent): IBinder? {
        return mMessenger.binder
    }

    private class MessengerHandler : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                WBConstants.MSG_FROM_CLIENT -> {
                    Logger.e(TAG + msg.data.getString("msg")!!)

                    // =====
                    val mFromClientMessenger = msg.replyTo
                    val relpyMessage = Message.obtain(null, WBConstants.MSG_FROM_SERVICE)
                    val bundle = Bundle()
                    bundle.putString("reply", "ok, i have reciver you msg, i will be reply soon!")
                    relpyMessage.data = bundle
                    try {
                        mFromClientMessenger.send(relpyMessage)
                    } catch (e: RemoteException) {
                        e.printStackTrace()
                    }
                    // =====
                }
                else -> super.handleMessage(msg)
            }
        }
    }

    companion object {
        private const val TAG = "MessengerService"
    }
}
