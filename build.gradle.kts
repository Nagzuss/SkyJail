plugins {
    kotlin("jvm") version "1.9.20" // Mise à jour vers la dernière version stable de Kotlin
    java
    id("com.github.johnrengelman.shadow") version "7.1.2" // Plugin Shadow pour créer le fat jar
}

group = "fr.nagzuss"
version = "1.0"
description = "Plugins  de teste de jail"

repositories {
    mavenCentral()
    maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/public/") }
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
    maven { url = uri("https://repo.extendedclip.com/releases/") }
    maven { url = uri("https://repo.aikar.co/nexus/content/groups/aikar/") }

    flatDir {
        dirs("libs")
    }
}

dependencies {
    compileOnly("org.github.paperspigot:paperspigot-api:1.8.8-R0.1-20160806.221350-1")
    compileOnly("me.clip:placeholderapi:2.11.6")

    implementation("co.aikar:acf-paper:0.5.1-SNAPSHOT")

    // Lombok version
    annotationProcessor("org.projectlombok:lombok:1.18.26")
    compileOnly("org.projectlombok:lombok:1.18.26")

    implementation("com.google.code.gson:gson:2.8.8")
    implementation("org.apache.httpcomponents:httpclient:4.5.13")

    implementation("mysql:mysql-connector-java:8.0.26")

    implementation(files("libs/CCORE-API.jar"))

}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }

    // Définir la tâche jar classique
    jar {
        archiveFileName.set("SkyJail.jar")
        manifest {
            attributes["Main-Class"] = "fr.neskuik.core.CraftyLobby"
        }
    }

    // Définir la tâche shadowJar pour créer un fat JAR
    shadowJar {
        archiveFileName.set("SkyJail.jar")  // Nom du fichier généré
        manifest {
            attributes["Main-Class"] = "fr.nagzuss.Main" // Définir la classe principale
        }
        mergeServiceFiles() // Permet de fusionner certains fichiers de service
        // Si tu veux, tu peux ajouter des exclusions pour ne pas inclure certaines dépendances dans le fat jar
        // exclusions += ['**/log4j/**'] // Par exemple, pour exclure un dossier ou des fichiers spécifiques
    }
}