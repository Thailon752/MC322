plugins {
<<<<<<< HEAD
    application
}

repositories {
=======
    // Usando Kotlin DSL, use a função id para plugins
    id("application")
}

repositories {
    // Repositório Maven Central
>>>>>>> 1cb0590c55434a3600cb9b3bf9a401dbc51d534c
    mavenCentral()
}

dependencies {
<<<<<<< HEAD
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    implementation("com.google.guava:guava:32.1.2-jre")
=======
    // Dependências do JAXB em Kotlin DSL
    implementation("javax.xml.bind:jaxb-api:2.3.1")
    implementation("org.glassfish.jaxb:jaxb-runtime:2.3.1")

    // JUnit para testes
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")

    // Dependência do Guava
    implementation("com.google.guava:guava:31.0.1-jre")
>>>>>>> 1cb0590c55434a3600cb9b3bf9a401dbc51d534c
}

java {
    toolchain {
<<<<<<< HEAD
        languageVersion.set(JavaLanguageVersion.of(17))
=======
        languageVersion.set(JavaLanguageVersion.of(21))
>>>>>>> 1cb0590c55434a3600cb9b3bf9a401dbc51d534c
    }
}

application {
<<<<<<< HEAD
    mainClass.set("taxi3.App")
}

// Explicitly define the JUnit Platform for tests
tasks.test {
=======
    // Definindo a classe principal da aplicação
    mainClass.set("taxi3.App")
}

tasks.named<Test>("test") {
>>>>>>> 1cb0590c55434a3600cb9b3bf9a401dbc51d534c
    useJUnitPlatform()
}
