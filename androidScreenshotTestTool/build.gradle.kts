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
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.0-alpha02")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.0-alpha02")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")

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

    api("com.google.testparameterinjector:test-parameter-injector:${Testing.parameterInjector}")
    api("com.google.truth:truth:1.1.3")
    api("app.cash.paparazzi:paparazzi:${Utils.paparazzi}")
}