plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {

    // Coroutines
    implementation(Dependencies.Coroutines.core)

    // Javax
    implementation(Dependencies.Javax.inject)
}