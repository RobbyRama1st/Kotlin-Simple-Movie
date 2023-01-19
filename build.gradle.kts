// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version("7.4.0") apply false
    id("com.android.library") version("7.4.0") apply false
//    id("org.jetbrains.kotlin.android") version '1.7.21' apply false
    kotlin("jvm") version Versions.kotlin
    kotlin("plugin.serialization") version Versions.kotlin
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
}