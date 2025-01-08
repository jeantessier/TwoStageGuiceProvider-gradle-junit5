plugins {
    id("java")
    id("jvm-test-suite")
    id("jacoco")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.guice)

    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.bundles.jmock)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
        }
    }
}
