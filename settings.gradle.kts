pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }

    versionCatalogs {
        create("libs") {
            version("compose", "1.5.4")
            version("compose-activity", "1.8.0")
            version("composeTetManifest", "1.6.0-alpha07")
            version("hilt", "2.48")
            version("material3", "1.1.2")
            version("kotlinBom", "1.8.0")
            version("kotlinCoroutines", "1.7.3")
            version("junitKtx", "1.1.5")
            version("junit", "4.13.2")
            version("test-espresso", "3.5.1")
            version("mockk", "1.13.8")
            version("jupiter", "5.8.2")
            version("test-mockk", "1.13.8")
            version("turbine", "1.0.0")
            version("navigation", "2.7.5")


            library("compose-ui", "androidx.compose.ui", "ui").versionRef("compose")
            library("compose-ui-tooling", "androidx.compose.ui", "ui-tooling").versionRef("compose")
            library("compose-ui-tooling-preview", "androidx.compose.ui", "ui-tooling-preview").versionRef("compose")
            library("compose-ui-graphics", "androidx.compose.ui", "ui-graphics").versionRef("compose")
            library("compose-ui-test", "androidx.compose.ui", "ui-test-junit4").versionRef("compose")
            library("compose-ui-test-manifest", "androidx.compose.ui", "ui-test-manifest").versionRef("compose")
            library("compose-activity", "androidx.activity", "activity-compose").versionRef("compose-activity")
            bundle("compose", listOf("compose-ui", "compose-ui-tooling", "compose-ui-tooling-preview" , "compose-ui-graphics" , "compose-ui-test",
                "compose-ui-test-manifest","compose-activity"))

            library("hilt", "com.google.dagger", "hilt-android").versionRef("hilt")
            library("hilt-compiler", "com.google.dagger", "hilt-android-compiler").versionRef("hilt")
            bundle("hilt", listOf("hilt", "hilt-compiler"))

            library("material3", "androidx.compose.material3", "material3").versionRef("material3")

            library("junit", "junit", "junit").versionRef("junit")

            library("kotlin-bom", "org.jetbrains.kotlin", "kotlin-bom").versionRef("kotlinBom")
            library("kotlin-coroutines", "org.jetbrains.kotlinx", "kotlinx-coroutines-core").versionRef("kotlinCoroutines")
            bundle("kotlin", listOf("kotlin-bom", "kotlin-coroutines"))

            library("navigation", "androidx.navigation", "navigation-compose").versionRef("navigation")

            library("jupiter", "org.junit.jupiter", "junit-jupiter-api").versionRef("jupiter")
            library("jupiter-engine", "org.junit.jupiter", "junit-jupiter-engine").versionRef("jupiter")
            bundle("jupiter", listOf("jupiter", "jupiter-engine"))

            library("test-coroutines", "org.jetbrains.kotlinx", "kotlinx-coroutines-test").versionRef("kotlinCoroutines")
            library("test-espresso", "androidx.test.espresso", "espresso-core").versionRef("test-espresso")
            library("test-mockk", "io.mockk", "mockk").versionRef("test-mockk")
            library("test-mockk-android", "io.mockk", "mockk-android").versionRef("test-mockk")
            library("test-turbine", "app.cash.turbine", "turbine").versionRef("turbine")
            library("test-hilt", "com.google.dagger", "hilt-android-testing").versionRef("hilt")
            library("test-junit", "androidx.test.ext", "junit-ktx").versionRef("junitKtx")
            library("test-navigation", "androidx.navigation", "navigation-testing").versionRef("navigation")
            bundle("test", listOf("test-hilt", "test-junit" ,"test-navigation", "test-espresso", "test-coroutines", "test-mockk", "test-turbine"))

        }
    }

}

rootProject.name = "MarvelComics"
include(":app")
include(":domain")
