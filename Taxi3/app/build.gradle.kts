plugins {
    // Usando Kotlin DSL, use a função id para plugins
    id("application")
}

repositories {
    // Repositório Maven Central
    mavenCentral()
}

dependencies {
    // Dependências do JAXB em Kotlin DSL
    implementation("javax.xml.bind:jaxb-api:2.3.1")
    implementation("org.glassfish.jaxb:jaxb-runtime:2.3.1")

    // JUnit para testes
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")

    // Dependência do Guava
    implementation("com.google.guava:guava:31.0.1-jre")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    // Definindo a classe principal da aplicação
    mainClass.set("taxi3.App")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
