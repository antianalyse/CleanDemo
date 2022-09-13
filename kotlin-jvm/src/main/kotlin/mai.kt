import java.io.BufferedWriter
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.nio.file.Files
import kotlin.io.path.Path

/**
 * @author     ：ChengShouYi
 * @date       ：2022/9/7 13:48
 * @description :TODO
 */

fun main(args: Array<String>) {

    val scanPath = "C:\\Users\\24697\\Desktop\\1.txt"

    BufferedWriter(
        OutputStreamWriter(
            FileOutputStream(scanPath.toString(), false), "UTF-8"
        )
    ).use { writer ->
        writer.write("77")
    }






}

