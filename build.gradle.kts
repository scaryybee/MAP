plugins {
    kotlin("jvm") version "1.5.31"
}

group = properties["group"]!!
version = properties["version"]!!

configurations {
    create("mojangMapping")
    create("spigotMapping")
}

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")

    implementation("io.github.monun:tap-api:4.1.2")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "16"
    }
}

