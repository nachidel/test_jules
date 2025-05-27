package com.productionapp.server.routes

import com.productionapp.shared.models.ProductionOrder
import com.productionapp.shared.models.ApiError // Import ApiError
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.HttpStatusCode // Required for HttpStatusCode

fun Route.configureProductionRoutes() {
    route("/api/production") {
        get("/orders") {
            // TODO: Replace with actual database query and filtering
            val mockOrders = listOf(
                ProductionOrder("OF001", "Machine A", "2023-01-10T08:00:00Z", "2023-01-10T16:00:00Z", "ART001", "Article Alpha"),
                ProductionOrder("OF002", "Machine B", "2023-01-10T09:00:00Z", "2023-01-10T17:00:00Z", "ART002", "Article Beta"),
                ProductionOrder("OF003", "Machine A", "2023-01-11T08:00:00Z", "2023-01-11T16:00:00Z", "ART003", "Article Gamma")
            )
            call.respond(mockOrders)
        }

        // Placeholder for starting an order - actual implementation later
        // The request body for this should be defined, e.g. a StartOrderRequest data class
        post("/orders/start") {
            // Example: Expecting a JSON body like: { "ofNumber": "OFXXX", "machineName": "MachineY", "previousOfNumber": "OFZZZ" }
            // val startRequest = call.receive<StartOrderRequest>() 
            // Actual logic for starting an order and closing previous will be added here
            call.respond(HttpStatusCode.NotImplemented, ApiError("Endpoint not fully implemented. Database and full logic pending."))
        }
    }
}
