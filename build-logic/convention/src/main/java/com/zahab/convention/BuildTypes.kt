package com.zahab.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.gradle.api.Project

internal fun Project.configureBuildTypes(
    extension: CommonExtension,
    extensionType: ExtensionType
) {
    val apiKey = gradleLocalProperties(rootDir, providers).getProperty("API_KEY")

    when (extensionType) {
        ExtensionType.APPLICATION -> {
            (extension as ApplicationExtension).apply {
                buildFeatures {
                    buildConfig = true
                }
                buildTypes {
                    debug {
                        configureDebugBuild(apiKey)
                    }
                    release {
                        configureReleaseBuild(extension, apiKey)
                    }
                }
            }
        }

        ExtensionType.LIBRARY -> {
            (extension as LibraryExtension).apply {
                buildFeatures {
                    buildConfig = true
                }
                buildTypes {
                    debug {
                        configureDebugBuild(apiKey)
                    }
                    release {
                        configureReleaseBuild(extension, apiKey)
                    }
                }
            }
        }
    }
}

private fun BuildType.configureDebugBuild(
    apiKey: String
) {
    buildConfigField("String", "API_KEY", "\"$apiKey\"")
    buildConfigField("String", "BASE_URL", "\"https://www.google.com\"")
}

private fun BuildType.configureReleaseBuild(
    extension: CommonExtension,
    apiKey: String
) {
    buildConfigField("String", "API_KEY", "\"$apiKey\"")
    buildConfigField("String", "BASE_URL", "\"https://www.google.com\"")


    isMinifyEnabled = true
    proguardFiles(
        extension.getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
    )
}
