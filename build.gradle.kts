plugins {
    kotlin("multiplatform") version "1.9.22" apply false
    kotlin("android") version "1.9.22" apply false
    id("com.android.application") version "8.2.0" apply false
    id("com.android.library") version "8.2.0" apply false
    kotlin("jvm") version "1.9.22" apply false
    kotlin("plugin.serialization") version "1.9.22" apply false
    id("org.jetbrains.compose") version "1.5.12" apply false // For Compose Multiplatform (desktop, js)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
