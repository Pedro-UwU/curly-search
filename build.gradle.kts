plugins {
    kotlin("jvm") version "2.0.0"
    `java-library`
    `maven-publish`
}

group = "com.pedrito"
version = "1.0-SNAPSHOT"

val jacksonVersion = "2.18.+"
repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${jacksonVersion}")
    implementation("com.fasterxml.jackson.core:jackson-databind:${jacksonVersion}")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:${jacksonVersion}")
}

java {
    withSourcesJar() // Include source JAR
    withJavadocJar() // Include Javadoc JAR
}

publishing {
    publications {
        create<MavenPublication>("curly-search") {
            from(components["java"])
            groupId = group.toString()
            version = project.version.toString()
        }
    }
    repositories {
        maven {
            name = "local"
            url = uri(layout.buildDirectory.dir("repo")) // Local repository in the build directory
        }
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}