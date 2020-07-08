package com.workbook.liuwb.mylibrary.utils

import android.app.Activity
import android.app.Application
import android.content.ComponentCallbacks
import android.content.res.Configuration
import androidx.annotation.NonNull

object DensityUtil {

    private const val BASE_DP = 460f

    private var sNonCompatDensity = 0f
    private var sNonCompatScaledDensity = 0f

    private lateinit var callbacks: ComponentCallbacks

    fun setCustomDensity(@NonNull application: Application, @NonNull activity: Activity) {

        callbacks = object : ComponentCallbacks {
            override fun onLowMemory() {
            }

            override fun onConfigurationChanged(newConfig: Configuration) {
                if (newConfig.fontScale > 0) {
                    sNonCompatScaledDensity = application.resources.displayMetrics.scaledDensity
                }
            }
        }

        val applicationDisplayMetrics = application.resources.displayMetrics

        if (sNonCompatDensity == 0f) {
            sNonCompatDensity = applicationDisplayMetrics.density
            sNonCompatScaledDensity = applicationDisplayMetrics.scaledDensity

            application.registerComponentCallbacks(callbacks)
        }

        val targetDensity = applicationDisplayMetrics.widthPixels / BASE_DP
        val targetScaledDensity = (sNonCompatScaledDensity / sNonCompatDensity) * targetDensity
        val targetDensityDpi = 160 * targetDensity

        applicationDisplayMetrics.density = targetDensity
        applicationDisplayMetrics.scaledDensity = targetScaledDensity
        applicationDisplayMetrics.densityDpi = targetDensityDpi.toInt()

        val activityDisplayMetrics = activity.resources.displayMetrics
        activityDisplayMetrics.density = targetDensity
        activityDisplayMetrics.scaledDensity = targetScaledDensity
        activityDisplayMetrics.densityDpi = targetDensityDpi.toInt()
    }

    fun releaseDensity(@NonNull application: Application) {
        application.unregisterComponentCallbacks(callbacks)
    }
}