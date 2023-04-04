package com.exam.firstapp.data

import com.exam.firstapp.database.SQLDelightDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(SQLDelightDatabase.Schema, "repository.db")
    }
}