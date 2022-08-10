import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

plugins {
    java
    id("org.springframework.boot") version "2.7.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.spring") version "1.7.10"
}

allprojects {
    group = "com.example"
    version = "1.0.0"

    apply {
        plugin("java")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.jetbrains.kotlin.jvm")
    }

    repositories {
        mavenLocal()
        maven {
            url = uri("https://mirrors.huaweicloud.com/repository/maven/huaweicloudsdk/")
        }
        mavenCentral()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
}


subprojects {
    dependencies {
        implementation("org.apache.logging.log4j:log4j-api:2.18.0")
        implementation("org.apache.logging.log4j:log4j-core:2.18.0")
        implementation("io.reactivex.rxjava3:rxjava:3.1.5")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
    }
}


buildscript {
    val kotlinVersion = "1.7.10"
    val springBootVersion = "2.7.2"

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
        classpath("org.jetbrains.kotlin:kotlin-allopen:${kotlinVersion}")
    }
}


