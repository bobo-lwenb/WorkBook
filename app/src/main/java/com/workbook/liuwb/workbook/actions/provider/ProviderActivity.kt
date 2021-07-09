package com.workbook.liuwb.workbook.actions.provider

import android.content.ContentValues
import android.database.ContentObserver
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.workbook.liuwb.workbook.databinding.ActivityProviderBinding

class ProviderActivity : AppCompatActivity() {

    private val binding: ActivityProviderBinding by lazy {
        ActivityProviderBinding.inflate(layoutInflater)
    }

    private val contentObserver: ContentObserver by lazy {
        val handler = Handler(Looper.getMainLooper())
        object : ContentObserver(handler) {
            override fun onChange(selfChange: Boolean, uri: Uri?) {
                super.onChange(selfChange, uri)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        contentResolver.registerContentObserver(STUDENT_URI, true, contentObserver)
        insertValues()
        queryValues()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (contentResolver != null) {
            contentResolver.unregisterContentObserver(contentObserver)
        }
    }

    private fun queryValues() {
        val cursor =
            contentResolver.query(STUDENT_URI, arrayOf("id", "name", "gender", "number", "score"), null, null, null)
        while (cursor?.moveToNext()!!) {
            val student = Student()
            student.id = cursor.getInt(cursor.getColumnIndex("id"))
            student.name = cursor.getString(cursor.getColumnIndex("name"))
            student.gender = cursor.getInt(cursor.getColumnIndex("gender"))
            student.number = cursor.getString(cursor.getColumnIndex("number"))
            student.score = cursor.getInt(cursor.getColumnIndex("score"))
            Log.d(TAG, student.toString())
        }
        cursor.close()
    }

    private fun insertValues() {
        val contentValues = ContentValues()
        contentValues.put("id", 0)
        contentValues.put("name", "peter")
        contentValues.put("gender", 0)
        contentValues.put("number", "201804081705")
        contentValues.put("score", "100")
        contentResolver.insert(STUDENT_URI, contentValues)
    }

    private fun updateValues() {
        val contentValues = ContentValues()
        contentValues.put("id", 0)
        contentValues.put("name", "update")
        contentValues.put("gender", 1)
        contentValues.put("number", "201804111048")
        contentValues.put("score", "90")
        contentResolver.update(STUDENT_URI, contentValues, "id = ?", arrayOf("0"))
    }

    private fun deleteValues() {
        contentResolver.delete(STUDENT_URI, "name = ?", arrayOf("update"))
    }

    companion object {
        private const val TAG = "ClientActivity"
        private const val AUTHORITY = "com.workbook.liuwb.workbook.anew.provider"
        private val STUDENT_URI = Uri.parse("content://$AUTHORITY/student")
    }
}