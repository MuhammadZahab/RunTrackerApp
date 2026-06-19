plugins {
    alias(libs.plugins.runtracker.android.library)
}

android {
    namespace = "com.zahab.run.network"
}

dependencies {
   implementation(projects.core.domain)
   implementation(projects.core.data)
}