package com.workbook.liuwb.workbook.service.bind.foregroundservice

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.IBinder
import com.workbook.liuwb.workbook.R

class MyService : Service() {

    private lateinit var notification: Notification

    companion object {
        private const val TAG = "MyService"
        private val ID = "channel_1"
        private val NAME = "前台服务"
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val manager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(ID, NAME, NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel)
            notification = Notification.Builder(this, ID)
                    .setContentTitle("收到一条重要通知")
                    .setContentText("这是重要通知")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .build()
        }
        startForeground(1, notification)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
    }
}