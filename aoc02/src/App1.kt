import java.io.File
import kotlin.streams.toList

fun main(args: Array<String>) {
    val input = getInput(args[0])
    println(input)
    operate(input)
    println(input)
}

fun getInput(fileName: String): MutableList<Int> {
    return File(fileName)
        .readText()
        .split(",")
        .stream()
        .mapToInt { it.toInt() }
        .toList()
        .toMutableList()
}

fun operate(code: MutableList<Int>): List<Int> {
    for (i in code.indices step 4) {
        if (code[i] == 99) break
        val result = operate(code[i], code[code[i + 1]], code[code[i + 2]])
        code[code[i + 3]] = result
    }
    return code
}

fun operate(op: Int, in1: Int, in2: Int): Int {
    return when (op) {
        1 -> in1 + in2
        2 -> in1 * in2
        else -> -1
    }
}