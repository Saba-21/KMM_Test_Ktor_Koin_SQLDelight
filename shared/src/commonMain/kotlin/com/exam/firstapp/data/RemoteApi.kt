package com.exam.firstapp.data

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class RemoteApi {

    private val address = "https://api.github.com/"

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun searchRepositories(query: String?): ResponseDTO {
        return httpClient.request(address) {
            method = HttpMethod.Get
            url {
                appendPathSegments("search", "repositories")
                if (!query.isNullOrEmpty()) {
                    parameters.append("q", query)
                }
            }
        }.body()
    }
}