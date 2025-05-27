package com.productionapp.shared.models

import kotlinx.serialization.Serializable

@Serializable
data class ProductionOrder(
    val ofNumber: String,
    val machine: String,
    val plannedStartDate: String, // Consider using kotlinx-datetime for proper date handling later
    val plannedEndDate: String,   // Consider using kotlinx-datetime for proper date handling later
    val articleId: String,
    val articleDescription: String
)
