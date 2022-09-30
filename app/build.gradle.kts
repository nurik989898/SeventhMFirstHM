plugins {
    id(Dependencies.Plugins.androidApplication)
    id(Dependencies.Plugins.jetbrainsKotlinAndroid)
    id(Dependencies.Plugins.daggerHiltAndroid)
    id("kotlin-kapt")
}

android {
    compileSdk = Dependencies.AppConfig.compileSdk

    defaultConfig {
        applicationId = Dependencies.AppConfig.applicationId
        minSdk = Dependencies.AppConfig.minSdk
        targetSdk = Dependencies.AppConfig.targetSdk
        versionCode = Dependencies.AppConfig.versionCode
        versionName = Dependencies.AppConfig.versionName

        testInstrumentationRunner = Dependencies.AppConfig.testInstrumentationRunner
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
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    // Domain module
    implementation(project(Dependencies.Modules.domain))

    // UI
    implementation(Dependencies.UI.androidCore)
    implementation(Dependencies.UI.appCompat)
    implementation(Dependencies.UI.material)
    implementation(Dependencies.UI.constraint)
    implementation(Dependencies.UI.legacy)
    testImplementation(Dependencies.UI.testJunit)
    androidTestImplementation(Dependencies.UI.testJunitAndroid)
    androidTestImplementation(Dependencies.UI.testEspresso)

    implementation(Dependencies.UI.androidFragmentKTX)

    // LiveData
    implementation(Dependencies.LiveData.lifecycleViewModel)
    implementation(Dependencies.LiveData.lifecycleLiveData)
    implementation(Dependencies.LiveData.lifecycleRunTime)

    // Coroutines
    implementation(Dependencies.Coroutines.android)

    // Room
    implementation(Dependencies.Room.roomRunTime)
    kapt(Dependencies.Room.roomCompiler)
    implementation(Dependencies.Room.roomKTX)

    // Dagger-Hilt
    implementation(Dependencies.DaggerHilt.daggerHiltAndroid)
    kapt(Dependencies.DaggerHilt.daggerHiltCompiler)

    // Navigation component
    implementation(Dependencies.NavigationComponent.navigationFragment)
    implementation(Dependencies.NavigationComponent.navigationUI)
}