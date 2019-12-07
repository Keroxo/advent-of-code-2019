import java.io.File
import java.util.stream.IntStream

fun main(args: Array<String>) {
    val weights = readInput(args[0])
    val requiredFuel = requiredFuelForModule(weights).sum()
    print("Fuel required:  $requiredFuel")
}

fun readInput(fileName: String): IntStream {
    val moduleWeights = File(fileName).inputStream()
    return moduleWeights
        .bufferedReader()
        .lines()
        .mapToInt { it.toInt() }
}

fun requiredFuelForModule(stream: IntStream): IntStream {
    return stream
        .map { requiredFuelForModule(it) }
}

fun requiredFuelForModule(mass: Int): Int {
    val a = mass / 3
    return a - 2
}