import java.util.stream.IntStream
import kotlin.streams.toList

fun main(args: Array<String>) {
    val weights = readInput(args[0])
    val requiredFuelForModule = requiredFuelForModule(weights).toList()
    val requiredFuelForFuel = requiredFuelForFuel(requiredFuelForModule.stream().mapToInt { it.toInt() })
    val requiredFuel = requiredFuelForModule.sum() + requiredFuelForFuel.sum()
    print("Fuel required:  $requiredFuel")
}

fun requiredFuelForFuel(stream: IntStream): IntStream {
    return stream
        .map { requiredFuelForFuel(it) }
}

fun requiredFuelForFuel(fuel: Int): Int {
    val requiredFuel = fuel / 3 - 2
    return if (requiredFuel > 0)
        requiredFuel + requiredFuelForFuel(requiredFuel)
    else 0
}