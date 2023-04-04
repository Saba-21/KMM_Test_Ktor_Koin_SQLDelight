package com.exam.firstapp.data

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
class RepositoryDTO(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val title: String,
)