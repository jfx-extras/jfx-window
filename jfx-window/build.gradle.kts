import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val projectVersion = "8.0.0.0"
val projectGroup = "org.jfxextras"
val projectArtifactId = "jfxwindow"

plugins {
    kotlin("jvm") version "1.3.30"
    java
    `java-library`
    `maven-publish`
    id("org.jetbrains.dokka") version "0.9.18"
    id("kotlinx-serialization") version "1.3.30"
    id("com.github.johnrengelman.shadow") version "5.0.0"
}

group = projectGroup
version = projectVersion

val projectTasks = tasks {
    val sourcesJar by creating(Jar::class) {
        dependsOn(JavaPlugin.CLASSES_TASK_NAME)
        classifier = "sources"
        from(sourceSets["main"].allSource)

        doLast { addBuildNumber() }
    }

    artifacts {
        add("archives", sourcesJar)
    }
}

repositories {
    maven("https://kotlin.bintray.com/kotlinx")
    mavenLocal()
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-serialization:1.3.30")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.11.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = projectGroup
            artifactId = projectArtifactId
            version = projectVersion

            from(components["java"])

            val sourcesArtifact = projectTasks["sourcesJar"]
            artifact(sourcesArtifact)
        }
    }
}

fun addBuildNumber() {
    val num = readBuildNumbers("buildnumber.txt")[0]
    val newBuildNum = num.toInt() + 1
    val buildFileName = File("buildnumber.txt")

    buildFileName.writeText("$newBuildNum\n")
}

fun readBuildNumbers(fileName: String): List<String>
        = File(fileName).readLines(Charsets.UTF_8)
