plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "ir.training.marvelcomics"
    compileSdk = 34

    defaultConfig {
        applicationId = "ir.training.marvelcomics"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    testOptions {
        packagingOptions {
            jniLibs {
                useLegacyPackaging = true
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    packaging {
        resources {
            resources.excludes.add("META-INF/*")
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }

    flavorDimensions.add("type")
    productFlavors {
        create("api") {
        }

        create("mock") {
        }
    }

}

dependencies {

    implementation(platform(libs.kotlin.bom))

    implementation(libs.compose.ui)
    implementation(libs.compose.activity)
    implementation(libs.material3)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.ui.graphics)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    implementation(libs.lifecycle)

    implementation(libs.navigation)

    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)

    implementation(libs.test.junit)
    testImplementation(libs.junit)
    testImplementation(libs.test.coroutines)
    testImplementation(libs.test.mockk)
    androidTestImplementation(libs.test.espresso)
    androidTestImplementation(libs.test.junit)
    androidTestImplementation(libs.compose.ui.test)

    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))

    implementation(libs.retrofit)
}

kapt {
    correctErrorTypes = true
}