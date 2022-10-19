import java.util.concurrent.Executors
import java.util.concurrent.Future

/**
 * @author     ：ChengShouYi
 * @date       ：2022/8/23 14:08
 * @description :TODO
 */

fun a() {
    val sum = 0
    val futures = mutableListOf<Future<*>>()

    for (i in 0 until 96) futures.add(Executors.newCachedThreadPool {
        val thread = Thread(it, "后台扫描工作线程")
        thread.isDaemon = true
        thread
    }.submit {
        synchronized(sum) {
            for (i in 0 until 100) {
                Thread.sleep(1000)
                Thread.sleep(20)
            }
        }
    })
    for (future in futures) {
        println(9633)
        future.get()
    }
}

