plugins {
    kotlin("jvm")
    kotlin("kapt")
    id("org.jetbrains.compose")
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

val dagger_version: String by project
val ktor_version: String by project

dependencies {
    val currentOs = compose.desktop.currentOs

    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(currentOs)

    //dagger
    implementation("com.google.dagger:dagger:$dagger_version")
    kapt("com.google.dagger:dagger-compiler:$dagger_version")

    //ktor
    implementation("io.ktor:ktor-client-core:$ktor_version")

}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}