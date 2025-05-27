package com.productionapp.shared.models

import kotlinx.serialization.Serializable

@Serializable
data class UserSession(
    val userId: String, // Or Int, depending on your DB schema
    val username: String,
    val accreditationLevel: String,
    val site: String,
    val mqttBrokerAddress: String,
    val mqttListeningTopic: String,
    val sessionToken: String, // To be used for subsequent API calls
    val sessionExpiryTimestamp: Long // Unix timestamp for when the session expires
)
