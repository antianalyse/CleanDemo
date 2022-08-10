import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        println(i)
        delay(2000) // preten
        println(i + 1000)
// d we are asynchronously waiting 100 ms
        emit(i) // emit next value
        println(i + 1000000)
    }
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple().collect { value ->
            println("-----------${value}")
            delay(5000) // pretend we are processing it for 300 ms
            println(value)
        }
    }
    println("Collected in $time ms")
}
