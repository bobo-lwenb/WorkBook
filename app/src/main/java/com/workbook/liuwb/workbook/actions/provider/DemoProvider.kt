package com.workbook.liuwb.workbook.actions.provider

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri

class DemoProvider : ContentProvider() {

    private lateinit var database: SQLiteDatabase
    private lateinit var uriMatcher: UriMatcher

    override fun onCreate(): Boolean {
        database = DBOpenHelper(context).writableDatabase
        DBOpenHelper(context).readableDatabase
        uriMatcher = UriMatcher(UriMatcher.NO_MATCH)
        uriMatcher.addURI(AUTHORITY, PATH, STUDENT_URI_CODE)
        return true
    }

    override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor? {
        val uriType = uriMatcher.match(uri)
        val cursor: Cursor
        when (uriType) {
            STUDENT_URI_CODE -> {
                cursor = database.query(DBOpenHelper.getTableName(), projection, selection, selectionArgs, null, null, sortOrder, null)
            }
            else -> throw IllegalArgumentException("UnSupport Uri : $uri")
        }
        return cursor
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val uriType = uriMatcher.match(uri)
        val rowInsert: Long
        when (uriType) {
            STUDENT_URI_CODE -> {
                rowInsert = database.insert(DBOpenHelper.getTableName(), null, values)
            }
            else -> throw IllegalArgumentException("UnSupport Uri : $uri")
        }
        if (rowInsert > -1) {
            context?.contentResolver?.notifyChange(uri, null)
            return ContentUris.withAppendedId(uri, rowInsert)
        }
        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        val uriType = uriMatcher.match(uri)
        val rowDelete: Int
        when (uriType) {
            STUDENT_URI_CODE -> {
                rowDelete = database.delete(DBOpenHelper.getTableName(), selection, selectionArgs)
            }
            else -> throw IllegalArgumentException("UnSupport Uri : $uri")
        }
        if (rowDelete > 0) {
            context?.contentResolver?.notifyChange(uri, null)
        }
        return rowDelete
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        val uriType = uriMatcher.match(uri)
        val rowUpdate: Int
        when (uriType) {
            STUDENT_URI_CODE -> {
                rowUpdate = database.update(DBOpenHelper.getTableName(), values, selection, selectionArgs)
            }
            else -> throw IllegalArgumentException("UnSupport Uri : $uri")
        }
        if (rowUpdate > 0) {
            context?.contentResolver?.notifyChange(uri, null)
        }
        return rowUpdate
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    companion object {
        private const val TAG = "DemoProvider"
        private const val AUTHORITY = "com.workbook.liuwb.workbook.actions.provider"
        private const val PATH = "student"
        private const val STUDENT_URI_CODE = 0
    }
}