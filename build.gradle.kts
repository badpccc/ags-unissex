plugins {
    id("java")
    application
    id("org.openjfx.javafxplugin") version "0.0.14"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("io.github.cdimascio:dotenv-java:3.2.0")
    implementation("org.postgresql:postgresql:42.6.0")
}

javafx {
    version = "21" // use a versão compatível com seu JDK (pode ser 17, 20 ou 21)
    modules = listOf("javafx.controls", "javafx.fxml")
}

application {
    mainClass.set("org.example.App") // ajuste o pacote/classe principal se mudar
}

tasks.test {
    useJUnitPlatform()
}


