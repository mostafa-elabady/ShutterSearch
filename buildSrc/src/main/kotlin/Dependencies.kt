const val kotlinVersion = "1.3.41"


object ApplicationId {
    const val id = "com.mostafa.shuttersearch"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val detekt = "1.0.0.RC8"
    const val mapsServiceVersion = "11.0.4"

    const val buildToolsVersion = "3.5.0"
    const val constraintLayout = "1.1.3"
    const val ktx = "1.0.2"
    const val appcompat = "1.0.2"
    const val design = "1.0.0"
    const val recyclerview = "1.0.0"
    const val junit4 = "4.12"
    const val testRunner = "1.2.0"
    const val espresso = "3.2.0"
    const val assertjCore = "3.12.2"
    const val mockitoKotlin = "2.1.0"
    const val mockitoInline = "3.0.0"
    const val robolectric = "3.6.1"
    const val javaxAnnotationsVersion = "1.0"
    const val javaxInjectVersion = "1"
    const val retrofitVersion = "2.6.1"
    const val loggingInterceptor = "4.0.0"
    const val archComponentsVersion = "1.1.1"
    const val rxJavaVersion = "2.2.10"
    const val rxAndroidVersion = "2.0.1"
    const val koinVersion = "2.0.1"
    const val moshiVersion = "1.8.0"
    const val roomVersion = "2.2.0-rc01"
    const val pagingVersion = "2.1.0"

    const val GLIDE_VERSION = "4.10.0"

}

object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kapt = "kotlin-kapt"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
}

object AndroidSdk {
    const val minSdk = 19
    const val compileSdk = 28
    const val targetSdk = 28
}

object Libraries {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val javaxAnnotation = "javax.annotation:jsr250-api:${Versions.javaxAnnotationsVersion}"
    const val javaxInject = "javax.inject:javax.inject:${Versions.javaxInjectVersion}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val rxjavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitVersion}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshiVersion}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"


    const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    const val archComponents = "android.arch.lifecycle:extensions:${Versions.archComponentsVersion}"
    const val archComponentsCompiler =
        "android.arch.lifecycle:compiler:${Versions.archComponentsVersion}"

    const val koinAndroid = "org.koin:koin-android:${Versions.koinVersion}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koinVersion}"
    const val koinScope = "org.koin:koin-android-scope:${Versions.koinVersion}"

    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE_VERSION}"

}

object AndroidX {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val design = "com.google.android.material:material:${Versions.design}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val room = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomRXJava = "androidx.room:room-rxjava2:${Versions.roomVersion}"
    const val paging = "androidx.paging:paging-runtime-ktx:${Versions.pagingVersion}"
    const val pagingRXJava = "androidx.paging:paging-rxjava2-ktx:${Versions.pagingVersion}"
}


object TestLibraries {
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val assertjCore = "org.assertj:assertj-core:${Versions.assertjCore}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    const val koinTest = "org.koin:koin-test:${Versions.koinVersion}"
    const val roomTest = "androidx.room:room-testing:${Versions.roomVersion}"
}

object CodeSmells {
    const val detekt =
        "gradle.plugin.io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.detekt}"
}

