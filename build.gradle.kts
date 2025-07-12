import java.io.File

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.klint) apply false
    alias(libs.plugins.hilt) apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
}

tasks.register("printPackages") {
    doLast {
        val baseDir = file("app/src/main/java")

        if (!baseDir.exists()) {
            println("Directory not found: ${baseDir.path}")
            return@doLast
        }

        println("Project Package Structure:\n")

        baseDir.walkTopDown()
            .filter { it.isDirectory || it.extension == "java" || it.extension == "kt" }
            .forEach { file ->
                if (file.isDirectory) {
                    // Print directory as a package name
                    println("\nPackage: ${file.path.replace(baseDir.path, "").replace(File.separator, ".").trim('.')}")
                } else {
                    // Print file inside the current package
                    println("  └── ${file.name}")
                }
            }
    }
}
