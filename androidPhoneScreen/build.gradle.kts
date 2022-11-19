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
    // https://github.com/cashapp/paparazzi/pull/605
    compileSdk = 32 // 33 for instrumentation tests

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
    implementation(project(":shared"))
    implementation(project(":androidDesignSystem"))

    api("androidx.compose.material3:material3-window-size-class:${Android.materialWindowSize}")

    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:${Utils.detekt}") // TODO add compose rules
    detektPlugins("ru.kode:detekt-rules-compose:${Utils.detektCompose}")

    testImplementation("com.google.testparameterinjector:test-parameter-injector:${Testing.parameterInjector}")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation(project(":androidScreenshotTestTool"))

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.2.1")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.2.1")
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
