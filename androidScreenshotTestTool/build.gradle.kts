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
    namespace = "by.game.binumbers.screenshot.test.tool"
    compileSdk = 32

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

    implementation("androidx.compose.material3:material3-window-size-class:${Android.materialWindowSize}")
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:${Utils.detekt}") // TODO add compose rules

    api("com.google.testparameterinjector:test-parameter-injector:${Testing.parameterInjector}")
    api("com.google.truth:truth:1.1.3")
    api("app.cash.paparazzi:paparazzi:${Utils.paparazzi}")
}