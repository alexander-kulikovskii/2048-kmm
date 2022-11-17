#!/usr/bin/env kotlin
@file:DependsOn("it.krzeminski:github-actions-kotlin-dsl:0.25.0")
@file:Import("Common.main.kts")

import it.krzeminski.githubactions.actions.actions.CheckoutV3
import it.krzeminski.githubactions.domain.RunnerType.UbuntuLatest
import it.krzeminski.githubactions.domain.triggers.PullRequest
import it.krzeminski.githubactions.dsl.workflow
import it.krzeminski.githubactions.yaml.writeToFile
import java.nio.file.Paths

val buildGame = workflow(
    name = "Build Game",
    on = listOf(
        PullRequest(),
    ),
    sourceFile = __FILE__.toPath(),
    targetFileName = "build_game.yaml",
) {
    val staticAnalysisJob = job(
        id = "static-analysis",
        name = "Static Analysis",
        runsOn = UbuntuLatest,
    ) {
        uses(CheckoutV3())
        cacheGradleFiles()
        setUpJDK()
        runGradleTask("Run Static Analysis", "detekt")
    }

    val unitTestJob = job(
        id = "unit-tests",
        name = "Debug Unit tests",
        runsOn = UbuntuLatest,
        needs = listOf(staticAnalysisJob)
    ) {
        uses(CheckoutV3())
        cacheGradleFiles()
        setUpJDK()
        runGradleTask("Run Debug Unit Tests", shared.gradle("testDebug"))
        publishResults(
            artifactName = "sharedUnitTests",
            "shared/build/reports/tests/testDebugUnitTest",
        )
    }

    job(
        id = "unit-tests-design-system",
        name = "Debug Unit tests for Design system",
        runsOn = UbuntuLatest,
        needs = listOf(staticAnalysisJob),
    ) {
        uses(CheckoutV3())
        cacheGradleFiles()
        setUpJDK()

        runGradleTask("Run Debug Unit Tests for Design system", androidUI.gradle("verifyPaparazziDebug"))
        publishResults(
            artifactName = "designSystemUnitTests",
            "androidDesignSystem/build/reports/tests/testDebugUnitTest",
            "androidDesignSystem/out/failures/",
        )
    }

    job(
        id = "unit-tests-android-screens",
        name = "Debug Unit tests for Android screens",
        runsOn = UbuntuLatest,
        needs = listOf(staticAnalysisJob),
    ) {
        uses(CheckoutV3())
        cacheGradleFiles()
        setUpJDK()
        runGradleTask("Run Debug Unit Tests for Android screens", androidScreens.gradle("verifyPaparazziDebug"))
        publishResults(
            artifactName = "androidScreenUnitTests",
            "androidPhoneScreen/build/reports/tests/testDebugUnitTest",
            "androidPhoneScreen/out/failures/",
        )
    }

    job(
        id = "build-game",
        name = "Build Game",
        runsOn = UbuntuLatest,
        needs = listOf(unitTestJob) //, unitTestDesignSystemJob)
    ) {
        uses(CheckoutV3())
        cacheGradleFiles()
        setUpJDK()
        runGradleTask("Build android app", android.gradle("assembleRelease"))
    }
}.writeToFile()
