plugins {
    id("com.android.application")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")

}

android {
    compileSdkVersion (30)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.example.lolgg"
        minSdkVersion(19)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        //vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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
        dataBinding = true
    }
}

dependencies {

    implementation(Libs.kotlinCore)
    implementation(Libs.androidXCore)
    implementation(Libs.appCompat)
    implementation(Libs.androidMaterial)
    implementation(Libs.constrainLayout)
    implementation(Libs.navgationFragment)
    implementation(Libs.navgationUi)
    implementation(Libs.lifecycleLivedata)
    implementation(Libs.lifecycleViewModel)
    implementation(Libs.retrofit2Moshi)
    implementation(Libs.moshiCore)
    implementation(Libs.roomRuntime)
    implementation(Libs.roomKtx)
    kapt(Libs.roomCompiler)
    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutinesAndroid)
    implementation(Libs.koinCore)
    implementation(Libs.koinAndroid)
    implementation(Libs.koinScope)
    implementation(Libs.koinViewModel)
    implementation(Libs.multidexCore)
    implementation(Libs.circleImageview)


    testImplementation(TestLibs.juint)
    androidTestImplementation(TestLibs.androidxjuint)
    androidTestImplementation(TestLibs.androidxEspresso)
}