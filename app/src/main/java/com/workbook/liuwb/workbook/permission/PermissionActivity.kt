package com.workbook.liuwb.workbook.permission

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.workbook.liuwb.mylibrary.utils.Logger
import com.workbook.liuwb.workbook.R

class PermissionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        val btnOne = findViewById<Button>(R.id.permi_one)

        btnOne.setOnClickListener { requestPermission() }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            111 -> {
                if (permissions.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Logger.e("PermissionActivity: 你选择了允许该权限")
                } else {
                    Logger.e("PermissionActivity: 你选择了拒绝该权限")
                }
            }
            else -> {
            }
        }
    }

    private fun requestPermission() {
        if (ContextCompat.checkSelfPermission(this@PermissionActivity, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this@PermissionActivity, Manifest.permission.CAMERA)) {
                Logger.e("PermissionActivity: 你已拒绝该权限，并可以提示开启")
                ActivityCompat.requestPermissions(this@PermissionActivity, arrayOf(Manifest.permission.CAMERA), 111)
            } else {
                Logger.e("PermissionActivity: 你已拒绝该权限，并不再提示开启")
                ActivityCompat.requestPermissions(this@PermissionActivity, arrayOf(Manifest.permission.CAMERA), 111)
            }
        } else {
            Logger.e("PermissionActivity: 你已允许该权限")
        }
    }
}