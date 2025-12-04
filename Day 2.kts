import java.io.File

val input = File("./input/Day2.txt").readText()


val ranges = input.split(",").map { it.split("-") }

var result = 0L

ranges.forEach { range ->
    for (i in range[0].toLong()..range[1].toLong()) {
        val iString = i.toString()

        for (j in 1..(iString.length/2)) {
            val chunked = iString.chunked(j)

            if (chunked.all { it == chunked[0] } && chunked.size > 1) {
                result += i
                break
            }
        }
    }
}

println(result)
