// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath(BuildPlugins.androidGradlePlugin)
        classpath(BuildPlugins.kotlinGradlePlugin)
        classpath(CodeSmells.detekt)
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt").version(Versions.detekt)

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