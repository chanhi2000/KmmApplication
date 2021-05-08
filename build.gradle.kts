buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(Kotlin.gradlePlugin)
        classpath(Kotlin.serialization)
        classpath(Gradle.tools)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()

    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.named<Wrapper>("wrapper") {
    gradleVersion = "6.8.2"
}