package com.workbook.liuwb.workbook.anrdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.workbook.liuwb.workbook.R;

public class ANRActivity extends AppCompatActivity implements View.OnClickListener {
    private MyReceiver receiver;

    public static final String ACTION_FIRST = "com.brotherd.broadcastdemo.BROADCAST_FIRST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anr);
        findViewById(R.id.btnSendGlobalBroadcast).setOnClickListener(this);
        /*
          注册广播
         */
        IntentFilter intentFilter = new IntentFilter(ACTION_FIRST);
        receiver = new MyReceiver();
        registerReceiver(receiver, intentFilter);
    }

    public void sendGlobalBroadcast() {
        Intent intent = new Intent();
        //设置前台广播的标志位
        intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND);
        intent.setAction(ACTION_FIRST);
        sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSendGlobalBroadcast:
                sendGlobalBroadcast();
                break;
            default:
                break;
        }
    }
}
