plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "5.0.0"
}

group = "org.jfxextras"
version = "0.0.0.1"

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://kotlin.bintray.com/kotlinx")
    jcenter()
}

application {
    group = "org.jfxextras"
    version = "0.0.0.1"
    applicationName = "jfx-window.jdemo"
    mainClassName = "com.mairwunnx.jdemo.EntryPoint"
}

dependencies {
    implementation("org.jfxextras:jfxwindow:8.+")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}