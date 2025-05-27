pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "ProductionApp"

include(":shared")
include(":androidApp")
include(":desktopApp")
include(":serverApp")
include(":jsApp") // Assuming a separate module for JS app, not just a target in shared
