import javafx.application.Application.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {


    println(" 0000000000000000000")

}


private suspend fun fc1() {
    delay(6000L)
    println("[firstCoroutineDemo] Hello, 1")
}

private suspend fun fc2() {
    delay(5000L)
    println("[firstCoroutineDemo] Hello, 2")
}





