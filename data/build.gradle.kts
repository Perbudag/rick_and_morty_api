plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

val ktor_version: String by project

dependencies {
    implementation(project(":domain"))

    //ktor
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}