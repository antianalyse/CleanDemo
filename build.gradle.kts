import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

plugins {
    java
    id("org.springframework.boot") version "2.7.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
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
//        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
        implementation("org.jetbrains.kotlin:kotlin-reflect")

//        implementation("cn.hutool:hutool-all:5.8.3")
//        implementation("mysql:mysql-connector-java:8.0.29")
//        implementation("io.reactivex.rxjava3:rxjava:3.1.5")
//        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")

        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
        implementation("org.springframework.boot:spring-boot-starter")
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "junit", module = "junit")
        }
    }

    tasks.test {
        useJUnitPlatform()
    }
}


buildscript {
    val kotlinVersion = "1.6.21"
    val springBootVersion = "2.7.2"

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
        classpath("org.jetbrains.kotlin:kotlin-allopen:${kotlinVersion}")
    }
}


