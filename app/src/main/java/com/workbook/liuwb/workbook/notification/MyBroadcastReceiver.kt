package com.workbook.liuwb.workbook.notification

import android.app.Notification
import android.app.RemoteInput
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.workbook.liuwb.mylibrary.utils.Logger
import com.workbook.liuwb.workbook.R

class MyBroadcastReceiver : BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context, intent: Intent) {
        Logger.e("qqqqqq")
        if (intent.hasExtra(Notification.EXTRA_NOTIFICATION_ID)) {
            val id = intent.getIntExtra(Notification.EXTRA_NOTIFICATION_ID, 112)
            val channel = intent.getStringExtra("CHANNEL_ID")
            val key = intent.getStringExtra("KEY")

            val text = RemoteInput.getResultsFromIntent(intent).getCharSequence(key)
            Logger.e("qqqqqq $text $id $key")

            val notificationCompat = NotificationCompat.Builder(context, channel)
                    .setSmallIcon(R.drawable.ic_icon)
                    .setContentText("1234567890")
                    .build()

            NotificationManagerCompat.from(context).apply {
                notify(id, notificationCompat)
            }
        }
    }
}