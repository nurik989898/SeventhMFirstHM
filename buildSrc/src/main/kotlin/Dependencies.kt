object Dependencies {

    object AppConfig {
        const val compileSdk = 32
        const val applicationId = "com.example.seventhmfirsthm"
        const val minSdk = 24
        const val targetSdk = 32
        const val versionCode = 1
        const val versionName = "1.0"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Plugins {
        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val jetbrainsKotlinAndroid = "org.jetbrains.kotlin.android"
        const val daggerHiltAndroid = "com.google.dagger.hilt.android"
    }

    object UI {
        const val androidCore = "androidx.core:core-ktx:1.7.0"
        const val appCompat = "androidx.appcompat:appcompat:1.5.0"
        const val material = "com.google.android.material:material:1.6.1"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val legacy = "androidx.legacy:legacy-support-v4:1.0.0"
        const val testJunit = "junit:junit:4.13.2"
        const val testJunitAndroid = "androidx.test.ext:junit:1.1.3"
        const val testEspresso = "androidx.test.espresso:espresso-core:3.4.0"
        const val androidFragmentKTX = "androidx.fragment:fragment-ktx:1.5.2"
    }

    object LiveData {
        private const val version = "2.6.0-alpha01"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        const val lifecycleRunTime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
    }

    object Coroutines {
        private const val version = "1.6.4"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    }

    object Room {
        private const val version = "2.4.3"
        const val roomRunTime = "androidx.room:room-runtime:$version"
        const val roomCompiler = "androidx.room:room-compiler:$version"
        const val roomKTX = "androidx.room:room-ktx:$version"
    }


    object DaggerHilt {
        private const val version = "2.43"
        const val daggerHiltAndroid = "com.google.dagger:hilt-android:$version"
        const val daggerHiltCompiler = "com.google.dagger:hilt-compiler:$version"
    }

    object NavigationComponent {
        private const val version = "2.5.1"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val navigationUI = "androidx.navigation:navigation-ui-ktx:$version"
    }

    object Javax {
        const val inject = "javax.inject:javax.inject:1"
    }

    object Modules {
        const val domain = ":domain"
        const val data = ":data"
    }
}