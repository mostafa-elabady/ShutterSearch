plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KAPT)
    id(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
}
android {
    compileSdkVersion(AndroidSdk.COMPILE_SDK)
    defaultConfig {
        applicationId = ApplicationId.ID
        minSdkVersion(AndroidSdk.MIN_SDK)
        targetSdkVersion(AndroidSdk.TARGET_SDK)
        versionCode = Releases.VERSION_CODE
        versionName = Releases.VERSION_NAME
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
    kapt(Libraries.ARCH_COMPONENT_COMPILER)
    kapt(AndroidX.ROOM_COMPILER)
    implementation(Libraries.KOTLIN_STDLIB)
    implementation(AndroidX.APP_COMPAT)
    implementation(Libraries.KTX)
    implementation(Libraries.CONSTRAINT_LAYOUT)
    implementation(Libraries.RX_ANDROID)
    implementation(Libraries.RXJAVA)
    implementation(AndroidX.RECYCLER_VIEW)
    implementation(Libraries.RETROFIT)
    implementation(Libraries.RXJAVA_ADAPTER)
    implementation(Libraries.MOSHI_CONVERTER)
    implementation(Libraries.MOSHI)
    implementation(Libraries.MOSHI_KOTLIN)
    implementation(Libraries.LOGGING_INTERCEPTOR)
    implementation(Libraries.ARCH_COMPONENTS)
    implementation(AndroidX.DESIGN)
    implementation(Libraries.KOIN_ANDROID)
    implementation(Libraries.KOIN_SCOPE)
    implementation(Libraries.KOIN_VIEWMODEL)
    implementation(AndroidX.ROOM)
    implementation(AndroidX.ROOM_RX_JAVA)
    implementation(AndroidX.PAGING)
    implementation(AndroidX.PAGING_RX_JAVA)
    implementation(Libraries.GLIDE)

    compileOnly(Libraries.JAVAX_ANNOTATION)
    compileOnly(Libraries.JAVAX_INJECT)

    androidTestImplementation(TestLibraries.JUNIT4)
    testImplementation(TestLibraries.ASSERT_J_CORE)
    testImplementation(TestLibraries.MOCKITO_KOTLIN)
    testImplementation(TestLibraries.MOCKITO_INLINE)
    androidTestImplementation(TestLibraries.KOIN_TEST) {
        exclude(group = "org.mockito")
    }
    testImplementation(TestLibraries.ROOM_TEST)

    androidTestImplementation(TestLibraries.TEST_RUNNER)
    androidTestImplementation(TestLibraries.TEST_RULES)
    androidTestImplementation(TestLibraries.ESPRESSO)
    androidTestImplementation(TestLibraries.ARCH_CORE_TEST)
    androidTestImplementation(TestLibraries.MOCKITO_ANDROID)
    androidTestImplementation(TestLibraries.MOCKITO_KOTLIN)

}
