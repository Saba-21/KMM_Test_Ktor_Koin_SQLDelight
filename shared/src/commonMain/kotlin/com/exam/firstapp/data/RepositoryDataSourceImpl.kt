package com.exam.firstapp.data

import com.exam.firstapp.database.SQLDelightDatabase
import com.exam.firstapp.domain.Repository
import com.exam.firstapp.domain.RepositoryDataSource

class RepositoryDataSourceImpl(databaseFactory: DatabaseDriverFactory) : RepositoryDataSource {

    private val database = SQLDelightDatabase(databaseFactory.createDriver())
    private val remoteApi = RemoteApi()

    override suspend fun getSavedRepositories(): List<Repository> {
        return database.repositoryQueries.getAllRepositories().executeAsList().map {
            Repository(it.id.toInt(), it.title)
        }
    }

    override suspend fun saveRepository(repository: Repository) {
        database.repositoryQueries.insertRepository(repository.id.toLong(), repository.title)
    }

    override suspend fun removeRepository(id: Int) {
        database.repositoryQueries.deleteRepository(id.toLong())
    }

    override suspend fun searchRepositories(query: String): List<Repository> {
        return remoteApi.searchRepositories(query).items.map {
            Repository(it.id, it.title)
        }
    }
}