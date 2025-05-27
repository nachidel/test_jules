plugins {
    kotlin("jvm")
    kotlin("plugin.serialization") // For Ktor content negotiation
    application // To easily run the server
}

group = "com.productionapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":shared")) // If server needs any shared logic
    implementation("io.ktor:ktor-server-core:2.3.7")
    implementation("io.ktor:ktor-server-netty:2.3.7")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.7")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7") // For JSON serialization in server
    implementation("ch.qos.logback:logback-classic:1.4.14") // For logging
    testImplementation(kotlin("test"))
    testImplementation("io.ktor:ktor-server-tests-jvm:2.3.7")
}

application {
    mainClass.set("com.productionapp.server.ServerKt") // Will create this file later
}

// Ensure Kotlin JVM target is 1.8 or higher
kotlin {
    jvmToolchain(11) // Ktor works well with 11+
}
