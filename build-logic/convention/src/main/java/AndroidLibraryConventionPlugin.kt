import com.android.build.api.dsl.LibraryExtension
import com.zahab.convention.ExtensionType
import com.zahab.convention.configureBuildTypes
import com.zahab.convention.configureKotlinAndroid
import com.zahab.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("com.android.library")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)

                configureBuildTypes(
                    extension = this,
                    extensionType = ExtensionType.LIBRARY
                )

                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")

                }
            }

            dependencies {
                "testImplementation"(kotlin("test"))
                "testImplementation"(libs.findLibrary("junit").get())
            }
        }
    }
}