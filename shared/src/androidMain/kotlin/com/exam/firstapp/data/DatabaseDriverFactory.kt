package com.exam.firstapp.data

import android.content.Context
import com.exam.firstapp.database.SQLDelightDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(SQLDelightDatabase.Schema, context, "repository.db")
    }
}