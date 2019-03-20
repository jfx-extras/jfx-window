plugins {
    java
}

group = "org.jfxextras"
version = "0.0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}