// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    val kotlinVersion by rootProject.extra { "1.9.10" }
    val hiltVersion by rootProject.extra { "2.47" }
    val navVersion by rootProject.extra { "2.7.6" }
    val kspVersion by rootProject.extra {"1.9.22-1.0.17"}

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.2.1")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${hiltVersion}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${navVersion}")
        classpath("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:${kspVersion}")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}