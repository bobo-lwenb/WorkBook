package com.workbook.liuwb.workbook.actions.viewdemo.notification

import android.app.Notification.EXTRA_NOTIFICATION_ID
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput
import com.workbook.liuwb.workbook.R
import com.workbook.liuwb.workbook.databinding.ActivityNotificationDemoBinding

class NotificationDemoActivity : AppCompatActivity(), View.OnClickListener {

    private val binding: ActivityNotificationDemoBinding by lazy {
        ActivityNotificationDemoBinding.inflate(layoutInflater)
    }

    private val CHANEEL_ID = "basic"
    private val CHANEEL_NAME = "channel name"
    private val CHANEEL_DESCRIPT = "channel textchannel textchannel textchannel textchannel text"

    private val NOTIFICATION_ID = 111
    private val KEY_TEXT_REPLY = "key_text_reply"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.notifiBasic.setOnClickListener(this)
        binding.notifiReply.setOnClickListener(this)
        binding.notifiBack.setOnClickListener(this)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.notifi_basic -> {
                val intent = Intent(this, TapActionActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    putExtra("data", "I am from notification~")
                }
                val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

                val receiverIntent = Intent(this, MyBroadcastReceiver::class.java).apply {
                    action = "com.lwb"
                    putExtra(EXTRA_NOTIFICATION_ID, 0)
                }
                val receiverPendingIntent = PendingIntent.getBroadcast(this, 0, receiverIntent, 0)

                val builder = NotificationCompat.Builder(this, CHANEEL_ID)
                    .setSmallIcon(R.drawable.ic_user)
                    .setContentTitle("ContentTitle")
                    .setContentText("Notice that the NotificationCompat.Builder constructor requires that you provide a channel ID. This is required for compatibility with Android 8.0 (API level 26) and higher, but is ignored by older versions.")
                    .setStyle(
                        NotificationCompat.BigTextStyle()
                            .bigText("Notice that the NotificationCompat.Builder constructor requires that you provide a channel ID. This is required for compatibility with Android 8.0 (API level 26) and higher, but is ignored by older versions.")
                    )
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(pendingIntent)
                    .addAction(R.drawable.ic_action_name, "SNOOZE", receiverPendingIntent)
                    .setAutoCancel(true)

                val notificationManager: NotificationManagerCompat = NotificationManagerCompat.from(this)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    // 创建渠道
                    val importance = NotificationManager.IMPORTANCE_HIGH
                    val channel = NotificationChannel(CHANEEL_ID, CHANEEL_NAME, importance).apply {
                        description = CHANEEL_DESCRIPT
                    }
                    notificationManager.createNotificationChannel(channel)
                }
                with(notificationManager) {
                    notify(NOTIFICATION_ID, builder.build())
                }

            }
            R.id.notifi_reply -> {
                // KEY_TEXT_REPLY用于系统之后检索输入框文本用
                val remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
                    setLabel("reply11")// 输入框提示信息
                    build()
                }
                val receiverIntent = Intent(this, MyBroadcastReceiver::class.java).apply {
                    action = "com.lwb"
                    putExtra(EXTRA_NOTIFICATION_ID, NOTIFICATION_ID)
                    putExtra("CHANNEL_ID", CHANEEL_ID)
                    putExtra("KEY", KEY_TEXT_REPLY)
                }
                val replyPendingIntent: PendingIntent =
                    PendingIntent.getBroadcast(applicationContext, 0, receiverIntent, PendingIntent.FLAG_UPDATE_CURRENT)

                val action: NotificationCompat.Action = NotificationCompat.Action.Builder(
                    R.drawable.ic_icon,
                    "reply1",// 回复按钮文本
                    replyPendingIntent
                )
                    .addRemoteInput(remoteInput)
                    .build()

                val builder = NotificationCompat.Builder(this, CHANEEL_ID)
                    .setSmallIcon(R.drawable.ic_user)
                    .setContentTitle("ContentTitle")
                    .setContentText("Notice that the NotificationCompat.Builder constructor requires that you provide a channel ID. This is required for compatibility with Android 8.0 (API level 26) and higher, but is ignored by older versions.")
                    .setStyle(
                        NotificationCompat.BigTextStyle()
                            .bigText("Notice that the NotificationCompat.Builder constructor requires that you provide a channel ID. This is required for compatibility with Android 8.0 (API level 26) and higher, but is ignored by older versions.")
                    )
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .addAction(action)
                    .setAutoCancel(true)

                val notificationManager: NotificationManagerCompat = NotificationManagerCompat.from(this)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val importance = NotificationManager.IMPORTANCE_HIGH
                    val channel = NotificationChannel(CHANEEL_ID, CHANEEL_NAME, importance).apply {
                        description = CHANEEL_DESCRIPT
                    }
                    notificationManager.createNotificationChannel(channel)
                }
                with(notificationManager) {
                    notify(NOTIFICATION_ID, builder.build())
                }
            }
            R.id.notifi_back -> {

            }
        }
    }

}