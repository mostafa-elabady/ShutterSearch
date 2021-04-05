const val KOTLIN_VERSION = "1.3.41"


object ApplicationId {
    const val ID = "com.mostafa.shuttersearch"
}

object Releases {
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"
}

object Versions {
    const val MOCKITO_ANDROID = "2.6.1"
    const val ARCH_CORE = "2.1.0"
    const val DETEKT = "1.0.0.RC8"

    const val BUILD_TOOLS_VERSION = "3.5.0"
    const val CONSTRAIN_TLAYOUT = "1.1.3"
    const val KTX = "1.0.2"
    const val APP_COMPAT = "1.0.2"
    const val DESIGN = "1.0.0"
    const val RECYCLER_VIEW = "1.0.0"
    const val JUNIT4 = "1.1.1"
    const val ANDROIDX_TEST = "1.1.0"
    const val ESPRESSO = "3.2.0"
    const val ASSERT_J_CORE = "3.12.2"
    const val MOCKITO_KOTLIN = "2.1.0"
    const val MOCKITO_INLINE = "3.0.0"
    const val JAVAX_ANNOTATIONS = "1.0"
    const val JAVAX_INJECT = "1"
    const val RETROFIT = "2.6.1"
    const val LOGGING_INTERCEPTOR = "4.0.0"
    const val ARCH_COMPONENTS = "1.1.1"
    const val RXJAVA = "2.2.10"
    const val RXANDROID = "2.0.1"
    const val KOIN = "2.0.1"
    const val MOSHI = "1.8.0"
    const val ROOM = "2.2.0-rc01"
    const val PAGING = "2.1.0"
    const val GLIDE_VERSION = "4.10.0"
    const val GOOGLE_SERVICES = "4.3.5"

}

object BuildPlugins {
    const val ANDROID_GRADLE_PLUGIN =
        "com.android.tools.build:gradle:${Versions.BUILD_TOOLS_VERSION}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"
    const val ANDROID_APPLICATION = "com.android.application"
    const val KOTLIN_ANDROID = "kotlin-android"
    const val KAPT = "kotlin-kapt"
    const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
}

object GooglePlugins{
    const val GOOGLE_SERVICES = "com.google.gms:google-services:${Versions.GOOGLE_SERVICES}"
}
object AndroidSdk {
    const val MIN_SDK = 19
    const val COMPILE_SDK = 28
    const val TARGET_SDK = 28
}

object Libraries {
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$KOTLIN_VERSION"
    const val KTX = "androidx.core:core-ktx:${Versions.KTX}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAIN_TLAYOUT}"

    const val JAVAX_ANNOTATION = "javax.annotation:jsr250-api:${Versions.JAVAX_ANNOTATIONS}"
    const val JAVAX_INJECT = "javax.inject:javax.inject:${Versions.JAVAX_INJECT}"
    const val RXJAVA = "io.reactivex.rxjava2:rxjava:${Versions.RXJAVA}"
    const val RX_ANDROID = "io.reactivex.rxjava2:rxandroid:${Versions.RXANDROID}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RXJAVA_ADAPTER = "com.squareup.retrofit2:adapter-rxjava2:${Versions.RETROFIT}"
    const val MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"
    const val MOSHI = "com.squareup.moshi:moshi:${Versions.MOSHI}"
    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"


    const val LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING_INTERCEPTOR}"
    const val ARCH_COMPONENTS =
        "android.arch.lifecycle:extensions:${Versions.ARCH_COMPONENTS}"
    const val ARCH_COMPONENT_COMPILER =
        "android.arch.lifecycle:compiler:${Versions.ARCH_COMPONENTS}"

    const val KOIN_ANDROID = "org.koin:koin-android:${Versions.KOIN}"
    const val KOIN_VIEWMODEL = "org.koin:koin-android-viewmodel:${Versions.KOIN}"
    const val KOIN_SCOPE = "org.koin:koin-android-scope:${Versions.KOIN}"

    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE_VERSION}"

}

object AndroidX {
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val DESIGN = "com.google.android.material:material:${Versions.DESIGN}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"
    const val ROOM = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
    const val ROOM_RX_JAVA = "androidx.room:room-rxjava2:${Versions.ROOM}"
    const val PAGING = "androidx.paging:paging-runtime-ktx:${Versions.PAGING}"
    const val PAGING_RX_JAVA = "androidx.paging:paging-rxjava2-ktx:${Versions.PAGING}"
}

object TestLibraries {
    const val JUNIT4 = "androidx.test.ext:junit:${Versions.JUNIT4}"
    const val TEST_RUNNER = "androidx.test:runner:${Versions.ANDROIDX_TEST}"
    const val TEST_RULES = "androidx.test:rules:${Versions.ANDROIDX_TEST}"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    const val ASSERT_J_CORE = "org.assertj:assertj-core:${Versions.ASSERT_J_CORE}"
    const val MOCKITO_KOTLIN =
        "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.MOCKITO_KOTLIN}"
    const val MOCKITO_INLINE = "org.mockito:mockito-inline:${Versions.MOCKITO_INLINE}"
    const val MOCKITO_ANDROID = "org.mockito:mockito-android:${Versions.MOCKITO_ANDROID}"
    const val KOIN_TEST = "org.koin:koin-test:${Versions.KOIN}"
    const val ROOM_TEST = "androidx.room:room-testing:${Versions.ROOM}"
    const val ARCH_CORE_TEST = "androidx.arch.core:core-testing:${Versions.ARCH_CORE}"
}

object CodeSmells {
    const val DETEKT =
        "gradle.plugin.io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.DETEKT}"
}

