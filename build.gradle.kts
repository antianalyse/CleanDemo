import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenLocal()
    maven {
        setUrl("https://maven.aliyun.com/nexus/content/groups/public")
    }
}

dependencies {
    implementation("cn.hutool:hutool-all:5.8.3")

//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.5")

//    implementation("com.fasterxml.jackson.core:jackson-core:2.9.5")
//    implementation("com.fasterxml.jackson.core:jackson-annotations:2.9.5")

    // databind 包含 core 和 annotations
//    implementation("com.fasterxml.jackson.core:jackson-databind:2.9.5")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3"){
//        exclude(module = "jackson-annotations")
//        exclude(module = "jackson-databind")
//        exclude(module = "jackson-core")
//        exclude(module = "kotlin-reflect")
    }

    implementation("mysql:mysql-connector-java:8.0.29")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

