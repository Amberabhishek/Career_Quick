plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.careerquick"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.careerquick"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("com.airbnb.android:lottie:4.1.0")
    implementation("androidx.fragment:fragment:1.3.6")
    implementation("com.google.gms:google-services:4.4.1")
    implementation("androidx.drawerlayout:drawerlayout:1.1.1")



    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.activity:activity:1.8.0")
    implementation("androidx.navigation:navigation-fragment:2.7.7")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
}