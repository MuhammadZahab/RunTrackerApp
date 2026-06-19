plugins {
    alias(libs.plugins.runtracker.android.library)
}

android {
    namespace = "com.zahab.run.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.google.android.gms.play.services.location)
    implementation(libs.androidx.work)
    implementation(libs.koin.android.workmanager)
    implementation(libs.kotlinx.serialization.json)
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.database)
    implementation(projects.run.domain)
    implementation(projects.run.location)
    implementation(projects.run.network)

}