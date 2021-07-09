package com.workbook.liuwb.workbook.actions.provider

import android.content.Context
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBOpenHelper : SQLiteOpenHelper {
    constructor(context: Context?) : super(context, DATABASE_NAME, null, DATABASE_VERSION) {}
    constructor(context: Context?, name: String, factory: CursorFactory, version: Int)
            : super(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    }

    constructor(context: Context?, name: String, factory: CursorFactory, version: Int, errorHandler: DatabaseErrorHandler)
            : super(context, DATABASE_NAME, factory, DATABASE_VERSION, errorHandler) {
    }

    override fun onCreate(db: SQLiteDatabase) {
        Log.d(TAG, "onCreate")
        db.execSQL(CREATE_STUDENT_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Log.d(TAG, "onUpgrade o = $oldVersion , n = $newVersion")
    }

    companion object {
        private const val TAG = "DBOpenHelper"
        private const val DATABASE_NAME = "demo_provider.db"
        private const val DATABASE_STUDENT_TABLE_NAME = "student"
        private const val DATABASE_VERSION = 1

        private const val CREATE_STUDENT_TABLE = ("CREATE TABLE IF NOT EXISTS "
                + DATABASE_STUDENT_TABLE_NAME
                + "(id INTEGER PRIMARY KEY,"
                + "name TEXT VARCHAR(20) NOT NULL,"
                + "gender BIT DEFAULT(1),"
                + "number TEXT VARCHAR(12) NOT NULL,"
                + "score INTEGER CHECK(score >= 0 and score <= 100))")

        fun getTableName(): String = DATABASE_STUDENT_TABLE_NAME
    }
}

