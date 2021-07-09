package com.workbook.liuwb.workbook.actions.designpattern.adapter;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("adapter pattern");
        setContentView(textView);

        // 对象适配器模式
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        User user = new User(target);
        user.call();

        // 类适配器模式
        target = new AdapterByExtends();
        user = new User(target);
        user.call();
    }
}
