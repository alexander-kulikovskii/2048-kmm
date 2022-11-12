#!/usr/bin/env kotlin
@file:DependsOn("it.krzeminski:github-actions-kotlin-dsl:0.25.0")
@file:Import("Common.main.kts")

import it.krzeminski.githubactions.actions.actions.CheckoutV3
import it.krzeminski.githubactions.domain.RunnerType.UbuntuLatest
import it.krzeminski.githubactions.domain.triggers.Push
import it.krzeminski.githubactions.dsl.workflow
import it.krzeminski.githubactions.yaml.writeToFile
import java.nio.file.Paths

val updateCache = workflow(
    name = "Update main branch cache",
    on = listOf(
        Push(
            branches = listOf("main"),
        ),
    ),
    sourceFile = __FILE__.toPath(),
    targetFileName = "update_cache.yaml",
) {
    job(
        id = "shared-tasks",
        name = "Shared tasks",
        runsOn = UbuntuLatest,
    ) {
        uses(CheckoutV3())
        cacheGradleFiles()
        setUpJDK()
        // TODO add check for cache hint
        // if: ${{ steps.cache-npm.outputs.cache-hit == 'false' }}
        runGradleTask("Run Static Analysis", android.gradle("tasks"))
    }
}.writeToFile()
