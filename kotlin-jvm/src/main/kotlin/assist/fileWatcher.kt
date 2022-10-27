package assist

import java.nio.file.FileSystems
import java.nio.file.Path
import java.nio.file.StandardWatchEventKinds
import java.nio.file.WatchService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.io.path.Path
import kotlin.io.path.exists
import kotlin.io.path.name

fun main() {

    val directory = Path("C:\\Users\\linel\\Desktop\\新建文件夹")

    val watcher: WatchService = FileSystems.getDefault().newWatchService().apply {
        directory.register(this, StandardWatchEventKinds.ENTRY_CREATE)
    }

    val filePath = directory.resolve("接收端.txt")

    var incrementalWaitTime = 100

    while (true) {
        incrementalWaitTime -= 1
        if (incrementalWaitTime < 0) {
            throw Exception()
        }
        watcher.poll(1, TimeUnit.SECONDS)?.let { watcherKey ->
            watcherKey.pollEvents().forEach { event ->
                event.takeIf {
                    it.kind() == StandardWatchEventKinds.ENTRY_CREATE
                }?.let {

                    val path = it.context() as Path

                    if (filePath.fileName == path.fileName) {
                        watcherKey.reset()
                        println("6666")
                        throw Exception()

                    }


                }
            }
            watcherKey.reset()
        }
    }


}


