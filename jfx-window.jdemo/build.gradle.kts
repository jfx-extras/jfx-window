plugins {
    java
    application
}

group = "org.jfxextras"
version = "0.0.0.1"

repositories {
    mavenLocal()
    mavenCentral()
}

application {
    group = "org.jfxextras"
    version = "0.0.0.1"
    applicationName = "jfx-window.jdemo"
    mainClassName = "com.mairwunnx.jdemo.EntryPoint"
}

dependencies {
    implementation("org.jfxextras:jfxwindow:0.0.0.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}