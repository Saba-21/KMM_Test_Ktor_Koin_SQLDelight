package com.exam.firstapp.di

import com.exam.firstapp.data.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual object DatabaseDriverModule {
    actual val module: Module = module {
        single {
            DatabaseDriverFactory(androidContext())
        }
    }
}