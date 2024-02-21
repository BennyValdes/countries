plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.countries"
    compileSdk = 34

    viewBinding{
        enable = true
    }

    defaultConfig {
        applicationId = "com.example.countries"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        multiDexEnabled = true
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    implementation("com.google.android.material:material:1.11.0")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("androidx.activity:activity-ktx:1.8.2")
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    
    implementation("com.google.code.gson:gson:2.10")
    implementation("androidx.test.ext:junit-ktx:1.1.5")

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:5.10.0")
    testImplementation("org.mockito:mockito-inline:3.12.4")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation ("io.mockk:mockk:1.12.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}