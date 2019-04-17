import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
    application
    id("com.github.johnrengelman.shadow") version "5.0.0"
}

group = "org.jfxextras"
version = "8.0.0.0"

repositories {
    maven("https://kotlin.bintray.com/kotlinx")
    mavenLocal()
    mavenCentral()
    jcenter()
}

application {
    group = "org.jfxextras"
    version = "8.0.0.0"
    applicationName = "jfx-window.kdemo"
    mainClassName = "com.mairwunnx.kdemo.EntryPoint"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jfxextras:jfxwindow:8.+")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}