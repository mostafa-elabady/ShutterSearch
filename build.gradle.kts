// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath(BuildPlugins.ANDROID_GRADLE_PLUGIN)
        classpath(BuildPlugins.KOTLIN_GRADLE_PLUGIN)
        classpath(CodeSmells.DETEKT)
        classpath(GooglePlugins.GOOGLE_SERVICES)
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt").version(Versions.DETEKT)

}

allprojects {

    apply("$rootDir/detekt.gradle")

    repositories {
        google()
        jcenter()

    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
