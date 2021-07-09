package com.workbook.liuwb.workbook.actions.designpattern.singleton;

import android.content.Context;

public class Singleton {
    private Context context;

    private Singleton(Context context) {
        this.context = context;
    }

    public static class Holder {
        private static Singleton Instance;

        public static Singleton getInstance(Context context) {
            if (Instance == null) {
                synchronized (Singleton.class) {
                    if (Instance == null) Instance = new Singleton(context);
                }
            }
            return Instance;
        }
    }
}
