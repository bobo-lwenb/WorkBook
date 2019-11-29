package com.workbook.liuwb.mylibrary.utils

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.os.Environment
import android.os.Looper
import android.os.Process

import com.workbook.liuwb.mylibrary.BuildConfig

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter
import java.text.SimpleDateFormat
import java.util.Date

class CrashHandler private constructor() : Thread.UncaughtExceptionHandler {
    private var uncaughtException: Thread.UncaughtExceptionHandler? = null
    private var mContext: Context? = null

    fun init(context: Context) {
        uncaughtException = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(this)
        mContext = context.applicationContext
    }


    /**
     * 这个是最关键的函数，当程序中有为捕获的异常，系统将会自动调用#uncaughtException方法
     *
     * @param thread    出现未捕获异常的线程
     * @param throwable 未捕获的异常
     */
    override fun uncaughtException(thread: Thread, throwable: Throwable) {
        try {
            dumpExceptionToSDCard(throwable)
            uploadExceptionToServer()
//            object : Thread() {
//                override fun run() {
//                    Looper.prepare()
//                    Looper.loop()
//                }
//            }.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        throwable.printStackTrace()
        // 如果系统提供了默认的异常处理器，则交给系统去结束程序，否则就自己结束自己
        if (null != uncaughtException) {
            uncaughtException!!.uncaughtException(thread, throwable)
        } else {
            Process.killProcess(Process.myPid())
        }
    }

    /**
     * 写入sdcard
     *
     * @param throwable
     * @throws IOException
     */
    @Throws(IOException::class)
    private fun dumpExceptionToSDCard(throwable: Throwable) {
        if (Environment.getExternalStorageState() != Environment.MEDIA_MOUNTED) {
            if (DEBUG) {
                return
            }
        }
        val dir = File(PATH)
        if (!dir.exists()) {
            dir.mkdirs()
        }
        val current = System.currentTimeMillis()
        val time = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date(current))
        val file = File(PATH + FILE_NAME + time + FILE_NAME_SUFFIX)

        try {
            val pw = PrintWriter(BufferedWriter(FileWriter(file)))
            pw.println(time)
            dumpPhoneInfo(pw)
            pw.println()
            throwable.printStackTrace(pw)
            pw.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * 获取手机信息
     *
     * @param pw
     * @throws PackageManager.NameNotFoundException
     */
    @Throws(PackageManager.NameNotFoundException::class)
    private fun dumpPhoneInfo(pw: PrintWriter) {
        val pm = mContext!!.packageManager
        val pi = pm.getPackageInfo(mContext!!.packageName, PackageManager.GET_ACTIVITIES)
        pw.print("App Version: ")
        pw.print(pi.versionName)
        pw.print("_")
        pw.println(pi.versionCode)

        pw.print("OS Version: ")
        pw.print(Build.VERSION.RELEASE)
        pw.print("_")
        pw.println(Build.VERSION.SDK_INT)

        pw.print("Vendor: ")
        pw.println(Build.MANUFACTURER)

        pw.print("Model: ")
        pw.println(Build.MODEL)

        pw.print("CPU ABI: ")
        pw.println(Build.CPU_ABI)
    }

    /**
     * 上传服务器
     */
    private fun uploadExceptionToServer() {}

    companion object {

        private val TAG = "CrashHandler"
        private val DEBUG = BuildConfig.DEBUG

        private val PATH = Environment.getExternalStorageDirectory().path + "/workbook/log/"
        private val FILE_NAME = "crash"
        private val FILE_NAME_SUFFIX = ".txt"

        private val sInstance = CrashHandler()

        fun getsInstance(): CrashHandler {
            return sInstance
        }
    }

}
