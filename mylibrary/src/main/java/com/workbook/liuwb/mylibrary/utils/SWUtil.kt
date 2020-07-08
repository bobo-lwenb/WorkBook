package com.workbook.liuwb.mylibrary.utils

import android.util.Log
import java.math.BigDecimal

class SWUtil {

    private val TAG = "SWUtil"

    private val baseDp = 360f
    private val swDp = listOf(240, 320, 360, 384, 400, 420, 432, 440, 480)
    private val dimens = listOf(5, 10, 15, 20, 25, 30)

    fun execute() {
        for (dp in swDp) {
            Log.v(TAG, "${dp}:---------------\n")
            for (dimen in dimens) {
                val aa = dimen * dp / baseDp
                val temp = BigDecimal(aa.toDouble()).setScale(4, BigDecimal.ROUND_HALF_UP)
                Log.v(TAG, "${dimen}: ${temp}dp\n")
            }
        }
    }
}