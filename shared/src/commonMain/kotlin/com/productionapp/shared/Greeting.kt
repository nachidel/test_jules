package com.productionapp.shared

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}

internal expect fun getPlatform(): Platform

internal interface Platform {
    val name: String
}
