fun main(args: Array<String>) {
    val input = getInput(args[0])
    val resultCode = search(args[1].toInt(), input)
    println(resultCode)
    println(100 * resultCode[1] + resultCode[2])
}

fun search(target: Int, code: List<Int>): List<Int> {
    for (i in 0..99) {
        for (j in 0..99) {
            val codeCopy = code.toMutableList()
            codeCopy[1] = i
            codeCopy[2] = j
            operate(codeCopy)
            if (codeCopy[0] == target) return codeCopy
        }
    }
    return emptyList()
}