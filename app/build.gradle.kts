plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("kapt")
    kotlin("android")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "net.arx.helloworldarx"
    compileSdk = 34

    defaultConfig {
        applicationId = "net.arx.helloworldarx"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    lint {
        abortOnError = false
    }

    signingConfigs {
        getByName("debug") {
            storeFile = file("keystore/dummy_keystore.keystore")
            keyAlias = "dummy_keystore"
            keyPassword = "123456!"
            storePassword = "123456!"
        }
        // here we should put the release keystore
        create("release") {
            storeFile = file("keystore/dummy_keystore.keystore")
            keyAlias = "dummy_keystore"
            keyPassword = "123456!"
            storePassword = "123456!"
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
            signingConfig = null
        }
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    flavorDimensions.add("env")
    productFlavors {
        create("dev") {
            dimension = "env"
            resValue("string", "app_name", "Hello World Arx Dev")
            buildConfigField("String", "TMDB_HOST_NAME", "\"api.themoviedb.org\"")
            applicationIdSuffix = ".dev"
            signingConfig = signingConfigs.getByName("debug")
        }
        create("prod") {
            dimension = "env"
            resValue("string", "app_name", "Hello World Arx")
            buildConfigField("String", "TMDB_HOST_NAME", "\"api.themoviedb.org\"")
            signingConfig = signingConfigs.getByName("release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    testOptions {
        packagingOptions {
            resources.excludes.add("META-INF/*")
            jniLibs {
                useLegacyPackaging = true
            }
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    applicationVariants.all {
        outputs.all {
            val output = (this as com.android.build.gradle.internal.api.BaseVariantOutputImpl)
            output.outputFileName = "${flavorName}_${versionName}_Hello_World_Arx_${buildType.name}.apk"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.browser:browser:1.7.0")

    val composeBom = platform("androidx.compose:compose-bom:2023.10.00")
    // use for main dependencies
    implementation(composeBom)
    // use for testing dependencies
    androidTestImplementation(composeBom)

    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation("androidx.lifecycle:lifecycle-runtime-compose")
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("androidx.compose.material3:material3-window-size-class:1.1.2")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    //implementation("androidx.lifecycle:lifecycle-runtime-compose:2.5.2")
    implementation("androidx.navigation:navigation-compose:2.7.6")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    //Hilt
    implementation("com.google.dagger:hilt-android:${rootProject.extra.get("hiltVersion")}")
    kapt("com.google.dagger:hilt-android-compiler:${rootProject.extra.get("hiltVersion")}")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:${rootProject.extra.get("navVersion")}")
    implementation("androidx.navigation:navigation-ui-ktx:${rootProject.extra.get("navVersion")}")

    implementation("com.jakewharton.timber:timber:5.0.1")

    val moshiVersion by extra { "1.15.0" }
    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion")

    val okHttpVersion by extra { "4.10.0" }
    implementation("com.squareup.okhttp3:okhttp:$okHttpVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okHttpVersion")

    val retrofitVersion by extra { "2.9.0" }
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")

    implementation("io.coil-kt:coil-compose:2.0.0")

    implementation("androidx.security:security-crypto-ktx:1.1.0-alpha06")

    // test
    testImplementation("junit:junit:")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("io.mockk:mockk:1.13.3")
    androidTestImplementation("io.mockk:mockk-android:1.13.3")
    testImplementation("org.junit.jupiter:junit-jupiter")
}