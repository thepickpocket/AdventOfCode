package helpers

import java.io.File

fun readFile(fileDestination: String): List<String> {
    return File("src/test/resources/$fileDestination").readLines()
}