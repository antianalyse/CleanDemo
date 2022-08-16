import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

tasks.compileJava {
    options.release.set(8)
}

plugins {
    java
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    id("org.springframework.boot") version "2.7.2"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
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

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
}



subprojects {
    dependencies {
//        implementation("org.apache.logging.log4j:log4j-api:2.18.0")
//        implementation("org.apache.logging.log4j:log4j-core:2.18.0")
//        implementation("io.reactivex.rxjava3:rxjava:3.1.5")
        implementation(platform("com.fasterxml.jackson:jackson-bom"))
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin") {
            because("使用无参构造")
        }
        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
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


tasks.register("cleane(清理所有任务的缓存)") {
    group = "开发辅助"
    description = "运行前,对所有任务缓存的清理"
    doLast {
        println(6696)
    }
}
