plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kapt)
    id(BuildPlugins.kotlinAndroidExtensions)
}

android {
    compileSdkVersion(AndroidSdk.compileSdk)
    defaultConfig {
        applicationId = ApplicationId.id
        minSdkVersion(AndroidSdk.minSdk)
        targetSdkVersion(AndroidSdk.targetSdk)
        versionCode = Releases.versionCode
        versionName = Releases.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}


dependencies {

    //    kapt(Libraries.daggerCompiler)
    kapt(Libraries.archComponentsCompiler)

//    implementation(Libraries.dagger)

    implementation(Libraries.kotlinStdLib)

    implementation(AndroidX.appcompat)
    implementation(Libraries.ktx)

    implementation(Libraries.constraintLayout)
    implementation(Libraries.rxAndroid)

    implementation(Libraries.rxJava)

    implementation(AndroidX.recyclerview)
    implementation(Libraries.retrofit)
    implementation(Libraries.rxjavaAdapter)
    implementation(Libraries.moshiConverter)
    implementation(Libraries.loggingInterceptor)
    implementation(Libraries.archComponents)
    implementation(AndroidX.design)
    implementation(Libraries.mapsService)

    compileOnly(Libraries.javaxAnnotation)
    compileOnly(Libraries.javaxInject)


    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.assertjCore)
    testImplementation(TestLibraries.mockitoKotlin)
    testImplementation(TestLibraries.mockitoInline)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)
}
