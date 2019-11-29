package com.workbook.liuwb.workbook

import android.app.Application
import com.workbook.liuwb.mylibrary.utils.CrashHandler
import me.jessyan.autosize.AutoSizeConfig
import me.jessyan.autosize.unit.Subunits

class WBApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CrashHandler.getsInstance().init(this)
        AutoSizeConfig.getInstance().unitsManager
                .setSupportDP(false)
//                .setSupportSP(false)
                .setSupportSubunits(Subunits.MM)
    }

}