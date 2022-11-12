#!/usr/bin/env kotlin
@file:DependsOn("it.krzeminski:github-actions-kotlin-dsl:0.25.0")
@file:Import("Common.main.kts")

import it.krzeminski.githubactions.actions.actions.CheckoutV3
import it.krzeminski.githubactions.domain.RunnerType.UbuntuLatest
import it.krzeminski.githubactions.domain.triggers.Schedule
import it.krzeminski.githubactions.domain.triggers.Cron
import it.krzeminski.githubactions.dsl.workflow
import it.krzeminski.githubactions.yaml.writeToFile
import java.nio.file.Paths

val updateCache = workflow(
    name = "Check new versions",
    on = listOf(
        Schedule(listOf(
            Cron(dayWeek = "0", hour = "8", minute = "0")
        )),
    ),
    sourceFile = __FILE__.toPath(),
    targetFileName = "project_dependencies.yaml",
) {
    job(
        id = "dependencies-tasks",
        name = "Dependencies tasks",
        runsOn = UbuntuLatest,
    ) {
        uses(CheckoutV3())
        cacheGradleFiles()
        setUpJDK()

        runGradleTask("Check android app", android.gradle("dependencyUpdates --stacktrace"))
        runGradleTask("Check android design system", androidUI.gradle("dependencyUpdates --stacktrace"))
        runGradleTask("Check shared", shared.gradle("dependencyUpdates --stacktrace"))
    }
}.writeToFile()
