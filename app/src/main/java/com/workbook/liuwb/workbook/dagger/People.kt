package com.workbook.liuwb.workbook.dagger

import com.workbook.liuwb.mylibrary.utils.Logger
import javax.inject.Inject

class People @Inject constructor(){
    fun hello() {
        Logger.e("lwb")
    }
}