fun main(args: Array<String>) {
    val input = args[0]
    println(low(input))
    println(high(input))
}

fun low(input: String): Int {
    return input.split("-")[0].toInt()
}
fun high(input: String): Int {
    return input.split("-")[1].toInt()
}

fun increasing(input: Array<Int>): Boolean {
    for(i in 0 until input.size-1) {

    }
}