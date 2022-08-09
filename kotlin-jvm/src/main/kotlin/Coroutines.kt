import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

var aa = 1

fun main() = runBlocking {
    println("Completed in  ms")

    for (i in 0..100) {
        launch {
            delay(2000)
             aa = aa+5
        }
    }

    println("wancheng") // main coroutine continues while a pre
    println(aa) // main coroutine continues while a previous one is delayed
// vious one is delayed

}



suspend fun doSomethingUsefulTwo(): Int {
    delay(4000L) // pretend we are doing something useful here, too
    return 29
}