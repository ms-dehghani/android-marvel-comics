plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "ir.training.marvelcomics.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    flavorDimensions.add("type")
    productFlavors {
        create("api") {
            namespace = "ir.training.marvelcomics.data"
            dimension = "type"

            buildConfigField ("String", "BASE_URL", "\"https://gateway.marvel.com:443/\"")
            buildConfigField ("String", "API_KEY", "\"9f9fb073b991c6fa7e25b6f5b1182af4\"")
            buildConfigField ("String", "API_HASH", "\"fc343222b79729980c2868355e5dddf395a17dc3\"")

            buildConfigField("boolean", "IS_MOCKED", false.toString())
        }

        create("mock") {
            namespace = "ir.training.marvelcomics.data"
            dimension = "type"

            buildConfigField("boolean", "IS_MOCKED", true.toString())
        }
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(project(mapOf("path" to ":domain")))

    implementation(libs.retrofit.gson)
    implementation(libs.retrofit)

    implementation(libs.room.runtime)

    kapt(libs.room.compiler)

    implementation(libs.kotlin.coroutines)

    implementation(libs.compose.activity)

    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    testImplementation(libs.test.mockk)

    testImplementation(libs.junit)
    testImplementation(libs.test.coroutines)

    testImplementation(libs.test.turbine)

    androidTestImplementation(libs.test.espresso)
    androidTestImplementation(libs.test.coroutines)
    androidTestImplementation(libs.test.junit)
    androidTestImplementation(libs.test.core.ktx)
    androidTestImplementation(libs.test.junit.ktx)
    androidTestImplementation(libs.test.room)


}