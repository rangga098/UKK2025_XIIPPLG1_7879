package com.example.ukk

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "todo_list.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "tasks"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TASK = "task"
        private const val COLUMN_STATUS = "status"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_TASK TEXT, $COLUMN_STATUS INTEGER)"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addTask(task: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_TASK, task)
        values.put(COLUMN_STATUS, 0) // 0 = not completed, 1 = completed
        val id = db.insert(TABLE_NAME, null, values)
        db.close()
        return id
    }

    fun getAllTasks(): List<Pair<Int, String>> {
        val taskList = mutableListOf<Pair<Int, String>>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
                val task = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TASK))
                taskList.add(Pair(id, task))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return taskList
    }

    fun updateTaskStatus(id: Int, status: Int): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_STATUS, status)
        val rowsUpdated = db.update(TABLE_NAME, values, "$COLUMN_ID = ?", arrayOf(id.toString()))
        db.close()
        return rowsUpdated
    }

    fun deleteTask(id: Int): Int {
        val db = this.writableDatabase
        val rowsDeleted = db.delete(TABLE_NAME, "$COLUMN_ID = ?", arrayOf(id.toString()))
        db.close()
        return rowsDeleted
    }
}
