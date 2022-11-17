plugins {
    id("com.android.application")
    kotlin("android")
    id("io.gitlab.arturbosch.detekt") version (Utils.detekt)
}
apply {
    from("$rootDir/gradle/dependency-updates.gradle")
}

android {
    compileSdk = Versions.compileSdkVersion
    defaultConfig {
        applicationId = Versions.applicationId
        minSdk = Versions.minSdkVersion
        targetSdk = Versions.targetSdkVersion
        versionCode = Versions.applicationVersionCode
        versionName = Versions.applicationVersionName
        resourceConfigurations.addAll(listOf("en", "ru"))
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = true

            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        create("benchmark") {
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
//            matchingFallbacks.addAll(listOf("release", "debug"))
            isDebuggable = false
//            isMinifyEnabled = true
//            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "benchmark-rules.pro")
        }
    }
    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget = Versions.jvmTarget
//        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
        freeCompilerArgs = freeCompilerArgs + "-opt-in=kotlin.RequiresOptIn"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Android.kotlinCompilerExtension
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":androidPhoneScreen"))
    implementation(project(":androidDesignSystem"))
    implementation("androidx.compose.material3:material3-window-size-class:${Android.materialWindowSize}")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.0-alpha03")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.0-alpha03")

    implementation("com.google.accompanist:accompanist-navigation-animation:0.27.0")
    implementation("androidx.profileinstaller:profileinstaller:1.3.0-alpha02")

    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:${Utils.detekt}")
}

project.apply {
    from("$rootDir/gradle/detekt.gradle")
}
