package com.exam.firstapp.di

import com.exam.firstapp.domain.RepositoryDataSource
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class DiHelper : KoinComponent {
    private val repositoryDataSource: RepositoryDataSource by inject()
    fun getDataSource() = repositoryDataSource
}

fun initKoin() {
    startKoin {
        modules(appModule())
    }
}