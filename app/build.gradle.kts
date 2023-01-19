import java.util.Properties
import java.io.FileInputStream

plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

val apikeyPropertiesFile by lazy { rootProject.file("apikey.properties") }
val apikeyProperties by lazy { Properties() }
apikeyProperties.load(FileInputStream(apikeyPropertiesFile))

android {
    namespace = AppInfo.applicationId
    compileSdk = AppInfo.compileSdkVersion

    defaultConfig {
        applicationId = AppInfo.applicationId
        minSdk = AppInfo.minSdkVersion
        targetSdk = AppInfo.targetSdkVersion
        versionCode = AppInfo.versionCode
        versionName = AppInfo.versionName

        buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org\"")
        buildConfigField("String", "API_KEY", "\"${apikeyProperties.getProperty("API_KEY")}\"")
        buildConfigField("String", "IMAGE_URL", "\"https://image.tmdb.org/t/p/original\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {

            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        targetCompatibility(JavaVersion.VERSION_11)
        sourceCompatibility(JavaVersion.VERSION_11)
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Deps.kotlin)
    implementation(Deps.kotlinReflect)
    implementation(Deps.appCompat)
    implementation(Deps.materialDesign)
    implementation(Deps.constraintLayout)
    implementation(Deps.legacySupport)
    implementation(Deps.browserHelper)
    implementation(Deps.glide)
    implementation(Deps.androidYoutubePlayer)

    // SquareUp
    implementation(platform(Deps.SquareUp.okhttpBOM))
    implementation(Deps.SquareUp.okhttp3)
    implementation(Deps.SquareUp.okhttp3Logging)
    implementation(Deps.SquareUp.retrofit)
    implementation(Deps.SquareUp.retrofitMoshi)
    implementation(Deps.SquareUp.moshi)

    // KOIN
    implementation(Deps.Koin.core)
    implementation(Deps.Koin.android)

    // LIFECYCLE
    implementation(Deps.lifecycleLiveData)
    implementation(Deps.lifecycleViewModel)
    testImplementation(Deps.archCoreTesting)

    // KOTLIN COROUTINES
    implementation(Deps.KotlinX.coroutineCore)
    implementation(Deps.KotlinX.coroutineAndroid)

    // ROOM
    implementation(Deps.Room.runtime)
    kapt(Kapt.roomCompiler)
    implementation(Deps.Room.ktx)

    // TESTING
    testImplementation(Deps.Testing.jUnit)
    testImplementation(Deps.Testing.mockito)

//    implementation 'androidx.core:core-ktx:1.9.0'
//    implementation 'androidx.appcompat:appcompat:1.6.0'
//    implementation 'com.google.android.material:material:1.7.0'
//    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
}