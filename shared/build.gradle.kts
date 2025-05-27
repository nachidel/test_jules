import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library") version "8.2.0" apply false // Apply false as it's for configuration, not direct application
    id("org.jetbrains.compose") // For potential common Compose UI
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    jvm("desktop") // Renaming the default jvm to desktop for clarity
    js(IR) {
        browser()
        binaries.executable()
    }
    // Add other necessary targets like iOS, macosX64, etc. if needed in the future
    // For now, keeping it to android, jvm (desktop), and js as requested.

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
                implementation("io.ktor:ktor-client-core:2.3.7")
                implementation("io.ktor:ktor-client-content-negotiation:2.3.7")
                implementation("io.ktor:ktor-serialization-kotlinx-json-client:2.3.7")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:2.3.7")
            }
        }
        val desktopMain by getting { // jvm("desktop") source set
            dependencies {
                implementation("io.ktor:ktor-client-cio:2.3.7") // For desktop Ktor client
            }
        }
        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:2.3.7")
            }
        }
    }
}

android {
    namespace = "com.productionapp.shared"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

// Configuration for org.jetbrains.compose (if you plan to use Compose Multiplatform in shared module)
// compose {
//     // Configure Compose options if needed
// }
