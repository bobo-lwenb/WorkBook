package com.workbook.liuwb.workbook.rxjava;

import android.os.Bundle;

import com.workbook.liuwb.workbook.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RxJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        runRxCode();
    }

    private void runRxCode() {

    }
}
