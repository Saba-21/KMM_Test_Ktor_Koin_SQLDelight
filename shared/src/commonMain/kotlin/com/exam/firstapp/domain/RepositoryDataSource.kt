package com.exam.firstapp.domain

interface RepositoryDataSource {
    suspend fun getSavedRepositories(): List<Repository>
    suspend fun saveRepository(repository: Repository)
    suspend fun removeRepository(id: Int)
    suspend fun searchRepositories(query: String): List<Repository>
}