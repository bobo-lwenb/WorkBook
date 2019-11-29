package com.workbook.liuwb.mylibrary.utils;

import android.util.Log;

import com.workbook.liuwb.mylibrary.BuildConfig;

public class Logger {

    public final static String TAG = "LOGGER";

    public static void i(String msg) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public static void v(String msg) {
        if (BuildConfig.DEBUG) {
            Log.v(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, msg);
        }
    }

    public static void w(String msg) {
        if (BuildConfig.DEBUG) {
            Log.w(TAG, msg);
        }
    }

    public static void e(String msg) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, msg);
        }
    }
}
