plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("io.gitlab.arturbosch.detekt") version Utils.detekt
    id("app.cash.paparazzi")
}
apply {
    from("$rootDir/gradle/dependency-updates.gradle")
}

android {
    compileSdk = 32 // https://github.com/cashapp/paparazzi/pull/605

    defaultConfig {
        minSdk = Versions.minSdkVersion
        targetSdk = Versions.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Versions.javaVersion
        targetCompatibility = Versions.javaVersion
    }
    kotlinOptions {
        jvmTarget = Versions.jvmTarget
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Android.kotlinCompilerExtension
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    api("androidx.compose.ui:ui:${Android.compose}")
    api("androidx.compose.ui:ui-tooling:${Android.compose}")
    api("androidx.compose.foundation:foundation:${Android.compose}")
    api("androidx.compose.material:material:${Android.compose}")
    api("androidx.activity:activity-compose:${Android.activityCompose}")

    api("com.google.android.material:material:${Android.composeAndroidMaterial}")
    api("androidx.compose.material3:material3:${Android.composeMaterial3}")
    api("androidx.compose.ui:ui-tooling-preview:${Android.compose}")
    api("com.google.accompanist:accompanist-systemuicontroller:${Android.accompanist}")

    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:${Utils.detekt}") // TODO add compose rules

    testImplementation("com.google.testparameterinjector:test-parameter-injector:${Testing.parameterInjector}")
    testImplementation(project(":androidScreenshotTestTool"))
}

tasks.withType<Test> {
    systemProperties["junit.jupiter.execution.parallel.enabled"] = true
    systemProperties["junit.jupiter.execution.parallel.mode.default"] = "concurrent"
    maxParallelForks = (Runtime.getRuntime().availableProcessors()).coerceAtLeast(1).also {
        println("Setting maxParallelForks to $it")
    }
}

project.apply {
    from("$rootDir/gradle/detekt.gradle")
}
