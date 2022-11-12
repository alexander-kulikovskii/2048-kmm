#!/usr/bin/env kotlin
@file:DependsOn("it.krzeminski:github-actions-kotlin-dsl:0.25.0")

import it.krzeminski.githubactions.actions.actions.CacheV3
import it.krzeminski.githubactions.actions.actions.SetupJavaV3
import it.krzeminski.githubactions.actions.actions.SetupJavaV3.Distribution.Adopt
import it.krzeminski.githubactions.actions.actions.UploadArtifactV3
import it.krzeminski.githubactions.actions.gradle.GradleBuildActionV2
import it.krzeminski.githubactions.dsl.JobBuilder
import it.krzeminski.githubactions.dsl.expressions.expr

val shared = "shared"
val android = "androidApp"
val ios = "ios"
val androidUI = "androidDesignSystem"
val androidScreens = "androidPhoneScreen"

fun JobBuilder.setUpJDK(
    javaVersion: String = "11",
    distribution: SetupJavaV3.Distribution = Adopt,
) {
    uses(
        name = "Set up JDK",
        action = SetupJavaV3(
            javaVersion = javaVersion,
            distribution = distribution,
        )
    )
}

fun JobBuilder.cacheGradleFiles(
) {
    uses(
        name = "Setup Gradle Dependencies Cache",
        action = CacheV3(
            path = listOf("~/.gradle"),
            key = expr { runner.os } +
                    "-gradle-caches-" +
                    expr { hashFiles("'**/*.gradle'", "'**/*.gradle.kts'", "'**/gradle/wrapper/gradle-wrapper.properties'") }
        )
    )
    uses(
        name = "Setup Kotlin Native compiler",
        action = CacheV3(
            path = listOf("~/.konan"),
            key = expr { runner.os } +
                    "-konan-caches-" +
                    expr { hashFiles("'**/*.gradle'", "'**/*.gradle.kts'") }
        )
    )
}

fun JobBuilder.runGradleTask(name: String, task: String) {
    run(name = name, command = "./gradlew $task")
}

fun JobBuilder.publishResults(artifactName: String, vararg path: String) {
    uses(
        name = "Publish results",
        condition = "always()",
        action = UploadArtifactV3(
            name = artifactName,
            path = path.toList(),
        )
    )
}

fun String.gradle(command: String): String = "$this:$command"