import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
}

dependencies {
    implementation(project(":shared"))
    implementation(compose.desktop.currentOs) // Manages platform-specific dependencies
    implementation(compose.material)
    implementation(compose.uiTooling)
    // Ktor client for JVM (CIO) is already in shared module's desktopMain (aliased from jvm)
}

compose.desktop {
    application {
        mainClass = "com.productionapp.desktop.MainKt" // Will create this file later
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ProductionAppDesktop"
            packageVersion = "1.0.0"
        }
    }
}

// Ensure Kotlin JVM target is 1.8 or higher if not already set by default by the plugin
kotlin {
    jvmToolchain(11) // Or 8, 17, etc. Compose Desktop works well with 11+
}
