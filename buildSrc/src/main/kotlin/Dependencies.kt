/**
 * To define plugins
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val serialization by lazy { "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}" }
}

/**
 * To define dependencies
 */
object Deps {
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}" }
    val kotlinReflect by lazy { "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}" }

    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val legacySupport by lazy { "androidx.legacy:legacy-support-v4:${Versions.legacySupport}" }
    val flexBox by lazy { "com.google.android.flexbox:flexbox:${Versions.flexBox}" }
    val browserHelper by lazy { "com.google.androidbrowserhelper:androidbrowserhelper:${Versions.browserHelper}" }
    val gson by lazy { "com.google.code.gson:gson:${Versions.gson}" }

    val workManagerKtx by lazy { "androidx.work:work-runtime-ktx:${Versions.workManagerKtxVersion}" }
    val fragmentKtx by lazy { "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}" }
    val navigationFragmentKtx by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigationUi}" }
    val navigationUiKtx by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigationUi}" }

    val glide by lazy { "com.github.bumptech.glide:glide:${Versions.glide}" }
    val glideOkhttp by lazy { "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}" }

    val lifecycleLiveData by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}" }
    val lifecycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}" }
    val lifecycleCompose by lazy {  "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleVersion}" }
    val lifecycleRuntime by lazy {  "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}" }
    val archCoreTesting by lazy { "androidx.arch.core:core-testing:${Versions.archVersion}" }

    val cameraXCore by lazy { "androidx.camera:camera-core:${Versions.cameraXVersion}" }
    val cameraXCamera2 by lazy { "androidx.camera:camera-camera2:${Versions.cameraXVersion}" }
    val cameraXLifecycle by lazy { "androidx.camera:camera-lifecycle:${Versions.cameraXVersion}" }
    val cameraXCameraView by lazy { "androidx.camera:camera-view:${Versions.cameraXVersion}" }

    val barcodeMLKit by lazy { "com.google.mlkit:barcode-scanning:${Versions.barcodeMLKit}" }

    val androidYoutubePlayer by lazy { "com.pierfrancescosoffritti.androidyoutubeplayer:chromecast-sender:${Versions.androidYoutubePlayerVersion}"}

    val playServicesMaps by lazy { "com.google.android.gms:play-services-maps:${Versions.playServicesMaps}" }
    val playServicesLocation by lazy { "com.google.android.gms:play-services-location:${Versions.playServicesLocation}" }
    val playServicesAuth by lazy { "com.google.android.gms:play-services-auth:${Versions.playServicesAuth}" }
    val librariesPlaces by lazy { "com.google.android.libraries.places:places:${Versions.librariesPlaces}" }

    val facebookShimmer by lazy { "com.facebook.shimmer:shimmer:${Versions.facebookShimmer}" }
    val htmlTextView by lazy { "org.sufficientlysecure:html-textview:${Versions.htmlTextView}" }
    val mpAndroidChart by lazy { "com.github.PhilJay:MPAndroidChart:${Versions.mpAndroidChart}" }
    val circleImageView by lazy { "de.hdodenhof:circleimageview:${Versions.circleImageView}" }
    val splitties by lazy { "com.louiscad.splitties:splitties-fun-pack-android-base:${Versions.splitties}" }
    val skydovesTooltip by lazy { "com.github.skydoves:balloon:${Versions.skydovesTooltip}" }
    val dotsIndicator by lazy { "com.tbuonomo:dotsindicator:${Versions.dotsIndicator}" }
    val spinKit by lazy { "com.github.ybq:Android-SpinKit:${Versions.spinKit}" }
    val prettyTime by lazy { "org.ocpsoft.prettytime:prettytime:${Versions.prettyTime}" }

    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }
    val chucker by lazy { "com.github.chuckerteam.chucker:library:${Versions.chucker}" }
    val chuckerRelease by lazy { "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}" }

    object Room {
        val ktx by lazy { "androidx.room:room-ktx:${Versions.roomVersion}" }
        val runtime by lazy {  "androidx.room:room-runtime:${Versions.roomVersion}" }
    }

    object KotlinX {
        val serialization by lazy { "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.KotlinX.serialization}" }
        val coroutineCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KotlinX.kotlinCoroutines}" }
        val coroutineAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KotlinX.kotlinCoroutines}" }
    }

    object Ktor {
        val core by lazy { "io.ktor:ktor-client-core:${Versions.ktor}" }
        val android by lazy { "io.ktor:ktor-client-android:${Versions.ktor}" }
        val serialization by lazy { "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}" }
        val logging by lazy { "io.ktor:ktor-client-logging:${Versions.ktor}" }
        val contentNegotiation by lazy { "io.ktor:ktor-client-content-negotiation:${Versions.ktor}" }
        val resources by lazy { "io.ktor:ktor-client-resources:${Versions.ktor}" }
        val cio by lazy { "io.ktor:ktor-client-cio:${Versions.ktor}" }
    }

    object Koin {
        val core by lazy { "io.insert-koin:koin-core:${Versions.koinVersion}" }
        val android by lazy { "io.insert-koin:koin-android:${Versions.koinAndroidVersion}" }
    }

    object Pusher {
        val javaClient by lazy { "com.pusher:pusher-java-client:${Versions.pusherJavaClient}" }
        val pushNotifications by lazy { "com.pusher:push-notifications-android:${Versions.pusherPushNotifications}" }
    }

    object Mapbox {
        val androidSdk by lazy { "com.mapbox.maps:android:${Versions.mapboxSdk}" }
        val searchSdk by lazy { "com.mapbox.search:mapbox-search-android-ui:${Versions.mapboxSearchSdk}" }
    }

    object SquareUp {
        val okhttpBOM by lazy { "com.squareup.okhttp3:okhttp-bom:${Versions.squareupOkhttp}" }
        val okhttp3 by lazy { "com.squareup.okhttp3:okhttp" }
        val okhttp3Logging by lazy { "com.squareup.okhttp3:logging-interceptor" }

        val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.squareupRetrofit}" }
        val retrofitMoshi by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.squareupRetrofit}" }

        val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshi}" }
    }

    object Firebase {
        val firebase by lazy { "com.google.firebase:firebase-bom:${Versions.firebaseBOM}" }
        val dynamicLinks by lazy { "com.google.firebase:firebase-dynamic-links" }
        val crashlytics by lazy { "com.google.firebase:firebase-crashlytics-ktx" }
        val analytics by lazy { "com.google.firebase:firebase-analytics-ktx" }
        val performance by lazy { "com.google.firebase:firebase-perf-ktx" }
        val messaging by lazy { "com.google.firebase:firebase-messaging-ktx" }
        val iid by lazy { "com.google.firebase:firebase-iid" }
    }

    object Compose {
        val navigation by lazy { "androidx.navigation:navigation-compose:${Versions.Compose.navigation}" }
        val activity by lazy { "androidx.activity:activity-compose:${Versions.Compose.activity}" }
        val material3 by lazy { "androidx.compose.material3:material3:${Versions.Compose.material3}" }
        val material by lazy { "androidx.compose.material:material:${Versions.Compose.material}" }
        val materialIcons by lazy { "androidx.compose.material:material-icons-core:${Versions.Compose.material}" }
        val materialIconsExt by lazy { "androidx.compose.material:material-icons-extended:${Versions.Compose.material}" }

        val foundation by lazy { "androidx.compose.foundation:foundation:${Versions.Compose.ui}" }

        val ui by lazy { "androidx.compose.ui:ui:${Versions.Compose.ui}" }
        val uiTooling by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.ui}" }

        val koin by lazy { "io.insert-koin:koin-androidx-compose:${Versions.Compose.koin}" }
    }

    object Testing {
        val jUnit by lazy { "junit:junit:${Versions.jUnit}" }
        val extJUnit by lazy { "androidx.test.ext:junit:${Versions.extJUnit}" }
        val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
        val mockito by lazy { "org.mockito:mockito-core:${Versions.mockito}" }
    }
}

/**
 * To define kapt
 */
object Kapt {
    val glide by lazy { "com.github.bumptech.glide:compiler:${Versions.glide}" }
    val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.roomVersion}" }
}

/**
 * To define app detail
 */
object AppInfo {
    val applicationId by lazy { "com.sweet.cloves.simplemovie" }
    val appName by lazy { "Simple Movie" }
    val versionCode by lazy { 1 }
    val versionName by lazy { "1.0" }
    val compileSdkVersion by lazy { 33 }
    val targetSdkVersion by lazy { 33 }
    val minSdkVersion by lazy { 24 }
}