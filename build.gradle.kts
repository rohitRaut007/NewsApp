// Top-level build file where you can add configuration options common to all sub-projects/modules.


plugins {
    alias(libs.plugins.android.application) apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

//    id ("androidx.navigation.safeargs.kotlin") version "2.5.3" apply false
}
buildscript {
    repositories {
        google()
    }
    dependencies {
       val nav_version = "2.8.3"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}
