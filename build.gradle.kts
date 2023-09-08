plugins {
    id("java")
}

group = "su.selezzz"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.mozilla:rhino-engine:1.7.13")
}

tasks.test {
    useJUnitPlatform()
}