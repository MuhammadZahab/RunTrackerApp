plugins {
    alias(libs.plugins.runtracker.android.library)
}

android {
    namespace = "com.zahab.run.location"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.google.android.gms.play.services.location)
    implementation(projects.core.domain)
    implementation(projects.run.domain)
}