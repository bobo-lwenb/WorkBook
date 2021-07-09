package com.workbook.liuwb.workbook

import android.app.Application
import com.workbook.liuwb.mylibrary.utils.CrashHandler

class WBApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CrashHandler.getsInstance().init(this)
    }
}