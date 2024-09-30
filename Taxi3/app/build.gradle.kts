plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    implementation("com.google.guava:guava:32.1.2-jre")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set("taxi3.App")
}

// Explicitly define the JUnit Platform for tests
tasks.test {
    useJUnitPlatform()
}
