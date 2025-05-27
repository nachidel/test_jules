package com.productionapp.server.routes

import com.productionapp.shared.models.Credentials
import com.productionapp.shared.models.UserSession
import com.productionapp.shared.models.ApiError // Import ApiError
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID
import io.ktor.http.HttpStatusCode // Required for HttpStatusCode

fun Route.configureAuthRoutes() {
    route("/api/auth") {
        post("/login") {
            try {
                val credentials = call.receive<Credentials>()
                // TODO: Replace with actual database authentication
                if (credentials.login == "testuser" && credentials.password == "password") {
                    val userSession = UserSession(
                        userId = "user-123",
                        username = credentials.login,
                        accreditationLevel = "admin",
                        site = "Site A",
                        mqttBrokerAddress = "tcp://localhost:1883",
                        mqttListeningTopic = "user/user-123/commands",
                        sessionToken = UUID.randomUUID().toString(),
                        sessionExpiryTimestamp = System.currentTimeMillis() + 3600_000 // 1 hour
                    )
                    call.respond(userSession)
                } else {
                    call.respond(HttpStatusCode.Unauthorized, ApiError("Invalid credentials"))
                }
            } catch (e: ContentTransformationException) { // More specific catch for deserialization issues
                call.respond(HttpStatusCode.BadRequest, ApiError("Bad request: Invalid format for credentials. ${e.message}"))
            } catch (e: Exception) {
                call.respond(HttpStatusCode.InternalServerError, ApiError("An unexpected error occurred: ${e.message}"))
            }
        }
    }
}
