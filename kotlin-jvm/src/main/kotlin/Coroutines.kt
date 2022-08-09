import kotlinx.coroutines.delay


suspend fun main() {


    println(" 0000000000000000000")


    val a = fc1()

}


private suspend fun fc1() {
    delay(6000L)
    println("[firstCoroutineDemo] Hello, 1")
}

private suspend fun fc2() {
    delay(5000L)
    println("[firstCoroutineDemo] Hello, 2")
}





