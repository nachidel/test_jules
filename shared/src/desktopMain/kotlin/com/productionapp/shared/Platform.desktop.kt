package com.productionapp.shared

internal actual fun getPlatform(): Platform = DesktopPlatform()

internal class DesktopPlatform : Platform {
    override val name: String = "Desktop (JVM ${System.getProperty("java.version")})"
}
