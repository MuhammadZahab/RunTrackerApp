import com.android.build.api.dsl.LibraryExtension
import com.zahab.convention.ExtensionType
import com.zahab.convention.configureAndroidCompose
import com.zahab.convention.configureBuildTypes
import com.zahab.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("runtracker.android.library")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.configure<LibraryExtension> {
                configureAndroidCompose(this)
            }

        }
    }
}