rootProject.name = "Cleandemo"

include("kotlin-web")
include("kotlin-jvm")

dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://maven.aliyun.com/repository/public/")
        }
        mavenCentral()
        maven {
            url = uri("https://mirrors.huaweicloud.com/repository/maven/huaweicloudsdk/")
        }
    }
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
}

