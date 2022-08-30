import java.security.SecureRandom
import java.util.*
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

/**
 * AES加密的工具类
 *
 * 算法: AES  工作模式: CBC  补码方式: PKCS5Padding
 *
 * CBC模式中Cipher不能是单例的（分组计算，加解密依赖于上一次加解密的结果）
 * */
object AesUtil {
    private const val algorithm = "AES/CBC/PKCS5Padding"
    private const val keyBase64 = "wXZuYS8mrHDN8AGFiX8tPw=="
    private const val ivBase64 = "vj/hykDCL8bZUD5ohLjNPw=="

    private val key = run {
        val keyBytes = Base64.getDecoder().decode(keyBase64)
        SecretKeySpec(keyBytes, 0, keyBytes.size, "AES")
    }
    private val iv = run {
        val ivBytes = Base64.getDecoder().decode(ivBase64)
        IvParameterSpec(ivBytes)
    }

    /**
     * 使用AES算法，对字节流进行加密
     * */
    fun encrypt(bytes: ByteArray): ByteArray {
        val cipher = Cipher.getInstance(algorithm)
        cipher.init(Cipher.ENCRYPT_MODE, key, iv)
        return cipher.doFinal(bytes)
    }

    /**
     * 使用AES算法，对字节流进行解密
     * */
    fun decrypt(bytes: ByteArray): ByteArray {
        val cipher = Cipher.getInstance(algorithm)
        cipher.init(Cipher.DECRYPT_MODE, key, iv)
        return cipher.doFinal(bytes)
    }

    /**
     * 生成一个随机 key ，并用 Base64 进行编码，上面已经生成了一个128位的key 并保存了下来
     * */
    @Suppress("unused")
    fun generateKey(n: Int): String {
        val keyGenerator = KeyGenerator.getInstance("AES")
        keyGenerator.init(n)
        val key = keyGenerator.generateKey()
        return Base64.getEncoder().encodeToString(key.encoded)
    }

    /**
     * 生成一个随机 IvParameterSpec ，并用 Base64 进行编码，上面已经生成了一个并保存了下来
     * */
    @Suppress("unused")
    fun generateIv(): String {
        val iv = ByteArray(16)
        SecureRandom().nextBytes(iv)
        val ivParameterSpec = IvParameterSpec(iv)
        return Base64.getEncoder().encodeToString(ivParameterSpec.iv)
    }
}

