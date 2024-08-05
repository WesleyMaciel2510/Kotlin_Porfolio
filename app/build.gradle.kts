plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    // passing data between screens and components
    kotlin("plugin.serialization") version "2.0.0"
}

android {
    namespace = "com.example.kotlin_portfolio"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kotlin_portfolio"
        minSdk = 26
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    // new libs to add =================
    // handle system inserts like back, home, options
    implementation ("androidx.core:core-ktx:1.13.1")
    implementation ("androidx.compose.foundation:foundation:1.4.0")
    implementation ("androidx.compose.ui:ui:1.4.0")
    implementation("androidx.compose.material:material:1.6.8")
    //end system inserts
    implementation ("com.airbnb.android:lottie-compose:5.0.3")
    implementation("androidx.media3:media3-common:1.4.0")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.compose.material:material:1.6.8")
    implementation("com.google.android.material:material:1.12.0")
    implementation ("androidx.compose.material:material-icons-extended:1.3.1")
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.compose.material)
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.14")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("io.coil-kt:coil-compose-base:2.7.0")
    // new libs end block ==============
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}