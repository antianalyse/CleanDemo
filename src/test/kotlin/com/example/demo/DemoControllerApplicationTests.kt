package com.example.demo

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class DemoControllerApplicationTests {

    val string = """
        [
    {
        "fieldName": "_fulltext",
        "columnIsMeta": true,
        "fieldDataType": "StringType",
         "fieldMetadata": { },
        "fieldData": "机密秘密绝密 机密秘密绝密 机密秘密绝密 机密秘密绝密 机密秘密绝密 机密秘密绝密 机密秘密绝密 机密秘密绝密 jdbc:mysql://192.168.100.48:3306/ceping_20220409/132b_character"
   }
    ]
"""

    @Test
    fun test() {
////        val objectMapper: ObjectMapper = ObjectMapper().findAndRegisterModules().registerModule(KotlinModule())
//        val objectMapper: ObjectMapper = jacksonObjectMapper()
//
//
//        val test = listOf(FieldDescription("haha", true, FieldDataType.TagType, mapOf(), "566"))
//        val testString = objectMapper.writeValueAsString(test)
//        testString
//        val typeReference = object : TypeReference<List<FieldDescription>>() {}
//        val state = objectMapper.readValue(testString, typeReference)
//        state
//

        val a: ByteArray? = null

        println( Base64.getEncoder().encodeToString(a))


    }
}

data class RowTransmission(
    val fieldDescriptionList: List<FieldDescription>
)

@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
data class FieldDescription(
    val fieldName: String,
    val columnIsMeta: Boolean,
    val fieldDataType: FieldDataType,
    val fieldMetadata: Map<String, String>?,
    val fieldData: Any?
) {
    constructor() : this("", false, FieldDataType.StringType, mapOf(), "")
}

enum class FieldDataType {
    TagType, MingzhongdecishuType, BooleanType, NumberType, StringType, BinaryType, BinariesType
}

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tagType")
@JsonSubTypes(
    JsonSubTypes.Type(value = SimpleTag::class, name = "SimpleTag"),
    JsonSubTypes.Type(value = PathTag::class, name = "PathTag"),
    JsonSubTypes.Type(value = AppendTag::class, name = "AppendTag"),
    JsonSubTypes.Type(value = EmbeddedTag::class, name = "EmbeddedTag"),
    JsonSubTypes.Type(value = FeatureWhiteTag::class, name = "FeatureWhiteTag"),
    JsonSubTypes.Type(value = FeatureBlackTag::class, name = "FeatureBlackTag"),
    JsonSubTypes.Type(value = RedHeadTag::class, name = "RedHeadTag"),
    JsonSubTypes.Type(value = SecurityTag::class, name = "SecurityTag"),
    JsonSubTypes.Type(value = SecurityNoMatchTag::class, name = "SecurityNoMatchTag"),
    JsonSubTypes.Type(value = PreciseBlackTag::class, name = "PreciseBlackTag"),
    JsonSubTypes.Type(value = PreciseWhiteTag::class, name = "PreciseWhiteTag")
)
sealed class TagNorm(
    val tagDescription: TagDescription, val path: String, val text: String, val range: IntRange?
)

class SimpleTag(tagDescription: TagDescription, path: String, text: String, range: IntRange?) :
    TagNorm(tagDescription, path, text, range)

class PathTag(tagDescription: TagDescription, path: String, val field: String, text: String, range: IntRange?) :
    TagNorm(tagDescription, path, text, range)

class AppendTag(tagDescription: TagDescription, path: String, text: String, range: IntRange?) :
    TagNorm(tagDescription, path, text, range)

class EmbeddedTag(
    tagDescription: TagDescription, path: String, text: String, range: IntRange?, val type: EmbeddedGenre
) : TagNorm(tagDescription, path, text, range)

class FeatureWhiteTag(tagDescription: TagDescription, path: String, text: String, range: IntRange?, val rate: Double) :
    TagNorm(tagDescription, path, text, range)

class FeatureBlackTag(tagDescription: TagDescription, path: String, text: String, range: IntRange?, val rate: Double) :
    TagNorm(tagDescription, path, text, range)

class RedHeadTag(tagDescription: TagDescription, path: String, text: String, range: IntRange?) :
    TagNorm(tagDescription, path, text, range)

class SecurityTag(
    tagDescription: TagDescription,
    path: String,
    text: String,
    range: IntRange?,
    val rate: Int,
    val safetyLevel: SafetyLevel
) : TagNorm(tagDescription, path, text, range)

class SecurityNoMatchTag(tagDescription: TagDescription, path: String, text: String, range: IntRange?) :
    TagNorm(tagDescription, path, text, range)

class PreciseBlackTag(tagType: TagDescription, path: String, text: String, range: IntRange?) :
    TagNorm(tagType, path, text, range)

class PreciseWhiteTag(tagType: TagDescription, path: String, text: String, range: IntRange?) :
    TagNorm(tagType, path, text, range)

/**
 * suoyouTag的注释
 * */
enum class TagDescription {
    /**
     * 身份证
     */
    IdentityCard,

    /**
     * 电话/手机号
     */
    TelNumber,

    /**
     * 路径
     */
    FilePath,

    /**
     * 邮件
     */
    Email,

    /**
     * 特征白名单
     */
    FeatureWhite,

    /**
     * 特征黑名单
     */
    FeatureBlack,

    /**
     * 红头
     */
    RedHead,

    /**
     * 疑似涉密
     */
    Security,

    /**
     * 高密低存
     *
     * 疑似存储了与密级不匹配的涉密信息
     */
    SecurityNoMatch,

    /**
     * 精确黑名单
     */
    PreciseBlack,

    /**
     * 精确白名单
     */
    PreciseWhite,

    /**
     * 加密文件
     */
    EncFile,

    /**
     * 加密邮件
     */
    EncMail,

    /**
     * 密标
     */
    LabelFile,

    /**
     * 文件夹带-拼接
     */
    Append,

    /**
     * 文件夹带-内嵌
     */
    InEmbed,

    /**
     * 文件夹带-外嵌
     */
    OutEmbed
}

enum class EmbeddedGenre {
    NEIQIAN, WAIQIAN, PINJIE
}

enum class SafetyLevel {
    /**
     * 公开
     */
    Public,

    /**
     * 内部
     */
    Inner,

    /**
     * 秘密
     */
    Mimi,

    /**
     * 机密
     */
    Jimi,

    /**
     * 绝密
     */
    Juemi,

    /**
     * 未知
     */
    Unknown
}

