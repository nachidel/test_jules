package com.productionapp.shared.models

import kotlinx.serialization.Serializable

@Serializable
data class ApiError(
    val message: String,
    val errorCode: Int? = null // Optional error code
)
