plugins {
    kotlin("jvm") version "2.0.0"
}

group = "com.tanucube.kit"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(project(":inputdevice"))

    implementation(libs.koin)
    implementation(libs.kotlin.coroutines)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}