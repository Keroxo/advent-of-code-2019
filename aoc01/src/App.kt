import java.io.File
import java.util.stream.IntStream

fun main(args: Array<String>) {
    val weights = readInput(args[0])
    val requiredFuel = requiredFuel(weights)
    print("Fuel required:  $requiredFuel")
}

fun readInput(fileName: String): IntStream {
    val moduleWeights = File(fileName).inputStream()
    return moduleWeights
        .bufferedReader()
        .lines()
        .mapToInt { it.toInt() }
}

fun requiredFuel(stream: IntStream): Int {
    return stream
        .map { requiredFuel(it) }
        .sum()
}

fun requiredFuel(mass: Int): Int {
    val a = mass / 3
    return a - 2
}