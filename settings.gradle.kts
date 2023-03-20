pluginManagement {
    buildscript {
        extra.apply {
            set("kotlin.version", "1.8.10")
            set("compose.version", "1.3.1")
        }
    }
    repositories {
        google()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    plugins {
        kotlin("jvm").version(extra["kotlin.version"].toString())
        kotlin("kapt").version(extra["kotlin.version"].toString())
        kotlin("plugin.serialization").version(extra["kotlin.version"].toString())
        id("org.jetbrains.compose").version(extra["compose.version"].toString())
    }
}

rootProject.name = "rick_and_morty_api"
include("app")
include("data")
include("domain")
