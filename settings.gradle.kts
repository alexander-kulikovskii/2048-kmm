pluginManagement {
    val kotlinVersion: String by settings
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        kotlin("multiplatform") version kotlinVersion apply false
        id("org.jetbrains.kotlin.jvm") version kotlinVersion
    }
}

rootProject.name = "2048"
include(":androidApp")
include(":shared")
include(":androidDesignSystem")
include(":androidPhoneScreen")
include(":androidScreenshotTestTool")
include(":macrobenchmark")
include(":microbenchmark")
