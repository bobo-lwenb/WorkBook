package com.workbook.liuwb.workbook.service.start

import android.app.IntentService
import android.content.Intent

/**
 * A constructor is required, and must call the super [android.app.IntentService.IntentService]
 * constructor with a name for the worker thread.
 */
class HelloIntentService : IntentService("HelloIntentService") {
    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    override fun onHandleIntent(p0: Intent?) {
        // Normally we would do some work here, like download a file.
        // For our sample, we just sleep for 5 seconds.
        try {
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            // Restore interrupt status.
            Thread.currentThread().interrupt()
        }
    }
}