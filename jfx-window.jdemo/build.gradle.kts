plugins {
    java
    application
    id("com.github.johnrengelman.shadow") version "5.0.0"
}

group = "org.jfxextras"
version = "8.0.0.229"

repositories {
    maven("https://kotlin.bintray.com/kotlinx")
    mavenLocal()
    mavenCentral()
    jcenter()
}

application {
    group = "org.jfxextras"
    version = "8.0.0.229"
    applicationName = "jfx-window.jdemo"
    mainClassName = "com.mairwunnx.jdemo.EntryPoint"
}

dependencies {
    implementation("org.jfxextras:jfxwindow:8.+")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}