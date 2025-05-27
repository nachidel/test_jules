package com.productionapp.shared

internal actual fun getPlatform(): Platform = AndroidPlatform()

internal class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}
