import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.util.concurrent.Executors
import kotlin.io.path.Path


class Tag(val a: String) {}
class TT(val name: String, val tags: List<Tag>)

fun main() {
    val objectMapper = jacksonObjectMapper()
    val filePath = Path("C:\\Users\\linel\\Desktop\\shuttle\\NODE1-2")

    val a = TT("123", emptyList())
    println(objectMapper.writeValueAsString(a))
    val ss = objectMapper.writeValueAsString(a)

    val typeReference = object : TypeReference<Map<String, Any>>() {}
    val fieldNormMap: Map<String, Any> = objectMapper.readValue(ss,typeReference)


   val data =  fieldNormMap["tags"]?.let {
        val reference = object : TypeReference<List<Tag>>() {}


        it

        objectMapper.convertValue(it, reference)
    }

    data


}