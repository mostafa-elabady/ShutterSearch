import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

val gitCommitCount = "git rev-list --count HEAD".runCommand().toInt()

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KAPT)
    id(BuildPlugins.KOTLIN_ANDROID_EXTENSIONS)
    id("com.google.gms.google-services")
    id("com.google.firebase.appdistribution")
}
android {
    compileSdkVersion(AndroidSdk.COMPILE_SDK)
    defaultConfig {
        applicationId = ApplicationId.ID
        minSdkVersion(AndroidSdk.MIN_SDK)
        targetSdkVersion(AndroidSdk.TARGET_SDK)
        versionCode = gitCommitCount
        versionName = Releases.VERSION_NAME
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "API_TOKEN", getLocalKey("API_TOKEN"))
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
    implementation(platform(Libraries.FIREBASE_BOM))

    compileOnly(Libraries.JAVAX_ANNOTATION)
    compileOnly(Libraries.JAVAX_INJECT)

    androidTestImplementation(TestLibraries.JUNIT4)
    testImplementation(TestLibraries.ASSERT_J_CORE)
    testImplementation(TestLibraries.MOCKITO_KOTLIN)
    testImplementation(TestLibraries.MOCKITO_INLINE)
    testImplementation(TestLibraries.ARCH_CORE_TEST)
    androidTestImplementation(TestLibraries.KOIN_TEST) {
        exclude("org.mockito")
        exclude("mockito-inline")
    }
    testImplementation(TestLibraries.ROOM_TEST)

    androidTestImplementation(TestLibraries.TEST_RUNNER)
    androidTestImplementation(TestLibraries.TEST_RULES)
    androidTestImplementation(TestLibraries.ESPRESSO)

    androidTestImplementation(TestLibraries.ARCH_CORE_TEST)
    androidTestImplementation(TestLibraries.MOCKITO_ANDROID)


}

fun getLocalKey(key: String): String = gradleLocalProperties(rootDir).getProperty(key)

fun String.runCommand(workingDir: File = file("./")): String {
    val parts = this.split("\\s".toRegex())
    val proc = ProcessBuilder(*parts.toTypedArray())
        .directory(workingDir)
        .redirectOutput(ProcessBuilder.Redirect.PIPE)
        .redirectError(ProcessBuilder.Redirect.PIPE)
        .start()

    proc.waitFor(1, TimeUnit.MINUTES)
    val res = proc.inputStream.bufferedReader().readText().trim()
    println("runCommand output:$res")
    return res
}
