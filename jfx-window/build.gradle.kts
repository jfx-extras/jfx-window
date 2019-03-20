import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.21"
    java
    `java-library`
    `maven-publish`
    id("org.jetbrains.dokka") version "0.9.17"
    id("com.github.johnrengelman.shadow") version "5.0.0"
}

group = "org.jfxextras"
version = "0.0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}