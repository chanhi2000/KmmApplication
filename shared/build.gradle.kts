import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("kotlinx-serialization")
    id("com.android.library")
    id("org.jetbrains.kotlin.native.cocoapods")
}

// CocoaPods requires the podspec to have a version.
version = "1.0"

android {
    compileSdkVersion(Versions.compileSdkVersion)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
//    configurations {
//        create("androidTestApi")
//        create("androidTestDebugApi")
//        create("androidTestReleaseApi")
//        create("testApi")
//        create("testDebugApi")
//        create("testReleaseApi")
//    }
}

kotlin {
    val sdkName: String? = System.getenv("SDK_NAME")

    /** iOS */
    val isiOSDevice = sdkName.orEmpty().startsWith("iphoneos")
    if (isiOSDevice) {
        iosArm64("ios")
    } else {
        iosX64("ios")
    }
    ios {
//        binaries {
//            framework {
//                baseName = "shared"
//            }
//        }
    }

    /** watchOS */
//    val isWatchOSDevice = sdkName.orEmpty().startsWith("watchos")
//    if (isWatchOSDevice) {
//        watchosArm64("watch")
//    } else {
//        watchosX86("watch")
//    }
//    macosX64("macOS")

    cocoapods {
        summary = "N/A"
        homepage = "N/A"
        ios.deploymentTarget = "14.1"
        frameworkName = "shared"
        podfile = project.file("../ios/Podfile")
    }

    android()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Kotlinx.datetime)
                implementation(Kotlinx.serializationJson)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Ktor.android)
                implementation(Ktor.serializationJvm)
                implementation(Kotlinx.coroutinesAndroid)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(Junit.core)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Ktor.ios)
            }
        }
        val iosTest by getting
    }
}