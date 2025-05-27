package com.productionapp.shared.models

import kotlinx.serialization.Serializable

@Serializable
data class Credentials(
    val login: String,
    val password: String
)
