plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("io.kotest.multiplatform")
    id("io.gitlab.arturbosch.detekt") version Utils.detekt
    id("dev.icerock.moko.kswift")
}
apply {
    from("$rootDir/gradle/dependency-updates.gradle")
}

version = Versions.sharedVersionName

kswift {

    install(MyKSwiftGenerator)
    install(ConnectedViewSwiftGenerator)
    install(dev.icerock.moko.kswift.plugin.feature.SealedToSwiftEnumFeature){
        filter = excludeFilter(
            "ClassContext/2048:shared/by/game/binumbers/splash/domain/model/SplashSideEffect",
            "ClassContext/2048:shared/by/game/binumbers/splash/domain/model/SplashAction",

            "ClassContext/2048:shared/by/game/binumbers/levels/domain/model/LevelsSideEffect",
            "ClassContext/2048:shared/by/game/binumbers/levels/domain/model/LevelsAction",

            "ClassContext/2048:shared/by/game/binumbers/main/domain/model/MainSideEffect",
            "ClassContext/2048:shared/by/game/binumbers/main/domain/model/MainAction",

            "ClassContext/2048:shared/by/game/binumbers/tutorial/domain/model/TutorialSideEffect",
            "ClassContext/2048:shared/by/game/binumbers/tutorial/domain/model/TutorialAction",

            "ClassContext/2048:shared/by/game/binumbers/game/domain/model/GameSideEffect",
            "ClassContext/2048:shared/by/game/binumbers/game/domain/model/GameAction",
        )
    }

    projectPodspecName.set("shared")
    iosDeploymentTarget.set("14.1")
}

kotlin {
    android()
    iosX64()
    iosArm64()
//    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
//                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-native-mt")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Coroutines.core}")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${Coroutines.serialization}")
                api("com.russhwolf:multiplatform-settings-no-arg:${Dependencies.multiplatformSettings}")
                implementation("io.insert-koin:koin-core:${Dependencies.koin}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("io.kotest:kotest-assertions-core:${Testing.kotest}")
                implementation("io.kotest:kotest-runner-junit5-jvm:${Testing.kotest}")
                implementation("io.kotest:kotest-framework-engine:${Testing.kotest}")
                implementation("io.kotest:kotest-framework-datatest:${Testing.kotest}")
                implementation("io.kotest.extensions:kotest-extensions-koin:1.1.0")
                implementation("io.insert-koin:koin-test:${Dependencies.koin}")

                implementation("io.mockk:mockk:${Testing.mockk}")
                implementation("io.mockk:mockk-agent-api:${Testing.mockk}")
                implementation("io.mockk:mockk-agent-jvm:${Testing.mockk}")
            }
        }

        val androidMain by getting {
            dependencies {
                api("androidx.lifecycle:lifecycle-viewmodel-ktx:${Lifecycle.viewModel}")
                api("androidx.navigation:navigation-compose:${Android.composeNavigation}")

                api("io.insert-koin:koin-core:${Dependencies.koin}")
                api("io.insert-koin:koin-android:${Dependencies.koin}")
                api("io.insert-koin:koin-androidx-compose:${Dependencies.koin}")
            }
        }
        val androidTest by getting
        val iosX64Main by getting
//        val iosArm64Main by getting
//        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
//            iosArm64Main.dependsOn(this)
//            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
//        val iosArm64Test by getting
//        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
//            iosArm64Test.dependsOn(this)
//            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = Versions.compileSdkVersion
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Versions.minSdkVersion
        targetSdk = Versions.targetSdkVersion
    }
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:${Utils.detekt}")
}

detekt {
    autoCorrect = true
    source = files(
        "src/commonMain/kotlin",
        "src/commonTest/kotlin",
        "src/iOSMain/kotlin",
        "src/androidMain/kotlin",
    )
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    filter {
        isFailOnNoMatchingTests = false
    }
    testLogging {
        showExceptions = true
        showStandardStreams = true
        events = setOf(
            org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
            org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
        )
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
    maxParallelForks = (Runtime.getRuntime().availableProcessors()).takeIf { it > 0 } ?: 1
}
