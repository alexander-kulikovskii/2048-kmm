buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("com.android.tools.build:gradle:${Dependencies.gradle}")
        classpath("io.kotest:kotest-framework-multiplatform-plugin-gradle:${Testing.kotest}")
        classpath("app.cash.paparazzi:paparazzi-gradle-plugin:${Utils.paparazzi}")
        classpath("com.github.ben-manes:gradle-versions-plugin:${Utils.gradleLibChecker}")
        classpath("dev.icerock.moko:kswift-gradle-plugin:0.5.0")
        classpath("app.cash.paparazzi:paparazzi:${Utils.paparazzi}")
        classpath("androidx.benchmark:benchmark-gradle-plugin:${Utils.benchmarkGradlePlugin}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven{url = uri("https://jitpack.io")}
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
