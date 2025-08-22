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
}

javafx {
    version = "21" // use a versão compatível com seu JDK (pode ser 17, 20 ou 21)
    modules = listOf("javafx.controls")
}

application {
    mainClass.set("com.example.App") // ajuste o pacote/classe principal se mudar
}

tasks.test {
    useJUnitPlatform()
}
