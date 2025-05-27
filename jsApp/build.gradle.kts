plugins {
    kotlin("js")
    id("org.jetbrains.compose")
}

kotlin {
    js(IR) { // Using IR compiler
        browser {
            commonWebpackConfig {
                outputFileName = "jsApp.js"
            }
        }
        binaries.executable()
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(compose.html.core) // Compose for Web core library
    implementation(compose.runtime) // Compose runtime
    // Ktor client for JS is already in shared module's jsMain
}

// Task to run the JS app using webpack dev server
tasks.register("jsBrowserDevelopmentRun", org.jetbrains.kotlin.gradle.targets.js.npm.tasks.KotlinNpmInstallTask::class.java) {
    dependsOn(tasks.named("jsDevelopmentExecutableCompileSync"))
    doLast {
        org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack.start(project, project.tasks.named("jsDevelopmentRun").get() as org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack)
    }
}

tasks.named("compileKotlinJs") {
    // Options can be configured here if needed for the JS compilation
}
