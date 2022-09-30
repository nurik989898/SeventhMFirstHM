// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id (Dependencies.Plugins.androidApplication) version "7.1.2" apply false
    id (Dependencies.Plugins.androidLibrary) version "7.1.2" apply false
    id (Dependencies.Plugins.jetbrainsKotlinAndroid) version "1.6.21" apply false
    id (Dependencies.Plugins.daggerHiltAndroid) version "2.43" apply false
}