import java.io.File
import kotlin.math.abs

val input = File("./input/Day1.txt").readLines()


val pairs = input.map { it.take(1) to Integer.parseInt(it.substring(1)) }

var current = 50
var result = 0

pairs.forEach { (direction, amount) ->
    var overflows = abs(amount / 100)
    if (direction == "L") {
        current = (current - amount).mod(100)
        if (current - amount > 0 && overflows > 0) {
            overflows--
        }
    } else {
        current = (current + amount).mod(100)
        if (current + amount < 100 && overflows > 0) {
            overflows--
        }
    }
    result += overflows

    if (current == 0 || overflows <= 0) {
        result++
    }
}

println(result)
