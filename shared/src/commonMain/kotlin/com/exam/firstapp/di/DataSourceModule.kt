package com.exam.firstapp.di

import com.exam.firstapp.data.RepositoryDataSourceImpl
import com.exam.firstapp.domain.RepositoryDataSource
import org.koin.core.module.Module
import org.koin.dsl.module

val dataSourceModule = module {
    single<RepositoryDataSource> {
        RepositoryDataSourceImpl(get())
    }
}

expect object DatabaseDriverModule {
    val module: Module
}

fun appModule() = listOf(DatabaseDriverModule.module, dataSourceModule)