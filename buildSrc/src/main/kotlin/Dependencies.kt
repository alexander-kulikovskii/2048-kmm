
import org.gradle.api.JavaVersion

object Versions {
    const val jvmTarget = "11"
    val javaVersion = JavaVersion.VERSION_11

    const val kotlin = "1.7.20"

    const val compileSdkVersion = 33
    const val minSdkVersion = 23
    const val targetSdkVersion = compileSdkVersion
    const val applicationId = "by.game.binumbers"
    const val applicationVersionCode = 100
    const val applicationVersionName = "1.0.0"

    const val sharedVersionName = "1.0.0"
}

object Testing {
    const val kotest = "5.5.1"
    const val mockk = "1.13.2"
    const val parameterInjector = "1.9"
}

object Dependencies {
    const val gradle = "7.3.0"
    const val multiplatformSettings = "0.9"
    const val koin = "3.2.0"
}

object Lifecycle {
    const val viewModel = "2.5.0"
}

object Coroutines {
    const val core = "1.6.4"
    const val serialization = "1.3.3"
}

object Android {
    // Compose
    const val compose = "1.2.1"
    const val kotlinCompilerExtension = "1.3.2"
    const val activityCompose = "1.4.0"
    const val composeAndroidMaterial = "1.5.0-alpha05"
    const val composeMaterial3 = "1.0.0-alpha01"
    const val accompanist = "0.17.0"
    const val materialWindowSize = "1.0.0-alpha14"

    const val composeNavigation = "2.5.0"
}

object Utils {
    const val detekt = "1.21.0"
    const val detektCompose = "1.2.2"
    const val paparazzi = "1.1.0"
    const val gradleLibChecker = "0.42.0"
    const val benchmarkGradlePlugin = "1.1.1"
}
