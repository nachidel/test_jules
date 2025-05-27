package com.productionapp.shared

internal actual fun getPlatform(): Platform = JsPlatform()

internal class JsPlatform : Platform {
    override val name: String = "JavaScript (Browser)"
}
