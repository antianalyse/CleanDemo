import java.util.concurrent.Executors

fun main() {

    Executors.newSingleThreadExecutor().submit {
        println(222)
    }

}


