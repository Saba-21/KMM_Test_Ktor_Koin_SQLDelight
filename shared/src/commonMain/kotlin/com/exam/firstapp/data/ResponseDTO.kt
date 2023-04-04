package com.exam.firstapp.data

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
class ResponseDTO(
    @SerialName("total_count")
    val count: Long,
    @SerialName("incomplete_results")
    val isIncomplete: Boolean,
    @SerialName("items")
    val items: List<RepositoryDTO>,
)