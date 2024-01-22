plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "ir.training.marvelcomics.domain"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
     buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    testImplementation(libs.test.mockk)

    implementation(libs.test.junit)
    testImplementation(libs.junit)

    testImplementation(libs.jupiter)
    testImplementation(libs.jupiter.engine)
}