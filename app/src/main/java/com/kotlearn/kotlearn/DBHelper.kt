package com.kotlearn.kotlearn

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context,
        DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "Topics.db"

        private val SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TableInfo.TABLE_NAME + " (" +
                        TableInfo.COLUMN_ID + " INT PRIMARY KEY," +
                        TableInfo.COLUMN_TOPIC_HEADER + " TEXT," +
                        TableInfo.COLUMN_TOPIC_CONTENT + " TEXT)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " +
                TableInfo.TABLE_NAME
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?,
                           oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase?,
                             oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    fun insertTopic(topic: TopicRecord): Boolean {
        val db = writableDatabase
        val values = ContentValues()

        values.put(TableInfo.COLUMN_ID, topic.id)
        values.put(TableInfo.COLUMN_TOPIC_HEADER, topic.topicHeader)
        values.put(TableInfo.COLUMN_TOPIC_CONTENT, topic.topicContent)

        val newRowId = db.insert(TableInfo.TABLE_NAME,
                null, values)
        return true
    }

    fun readTopic(id: Int): ArrayList<TopicRecord> {
        val topics = ArrayList<TopicRecord>()
        val db = writableDatabase
        var cursor: Cursor? = null

        try {
            cursor = db.rawQuery("select * from " +
                 TableInfo.TABLE_NAME + " WHERE " +
                 TableInfo.COLUMN_ID + "=" + id + "", null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }
        var topicHeader: String
        var topicContent: String

        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                topicContent = cursor.getString(cursor.getColumnIndex(TableInfo.COLUMN_TOPIC_CONTENT))
                topicHeader= cursor.getString(cursor.getColumnIndex(TableInfo.COLUMN_TOPIC_HEADER))
                topics.add(TopicRecord(id, topicHeader, topicContent))
                cursor.moveToNext()
            }
        }
        return topics
    }

    fun readAllTopics(): ArrayList<TopicRecord> {
        val topics = ArrayList<TopicRecord>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from "+ TableInfo.TABLE_NAME, null)

        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var id: Int
        var topicHeader: String
        var topicContent: String
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                id = cursor.getInt(cursor.getColumnIndex(TableInfo.COLUMN_ID))
                topicHeader = cursor.getString(cursor.getColumnIndex(TableInfo.COLUMN_TOPIC_HEADER))
                topicContent = cursor.getString(cursor.getColumnIndex(TableInfo.COLUMN_TOPIC_CONTENT))
                topics.add(TopicRecord(id, topicHeader, topicContent))
                cursor.moveToNext()
            }
        }
        return topics
    }

}
















