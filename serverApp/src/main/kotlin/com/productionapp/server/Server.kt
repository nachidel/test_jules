package com.productionapp.server

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import com.productionapp.server.routes.configureAuthRoutes
import com.productionapp.server.routes.configureProductionRoutes 
import io.ktor.server.response.* // Required for call.respondText

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module).start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureRouting()
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json() // Using kotlinx.serialization
    }
}

fun Application.configureRouting() {
    routing {
        // Define a simple health check route
        get("/") {
            call.respondText("ProductionApp Server is running!")
        }
        // We will add specific routes here
        configureAuthRoutes()
        configureProductionRoutes()
    }
}
