//package assist
//
//import com.fasterxml.jackson.annotation.JsonTypeInfo
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize
//import com.fasterxml.jackson.databind.annotation.JsonSerialize
//
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "transNormType")
//sealed class TransNorm
//class DataRowTransNorm(val rowNorm: RowNorm) : TransNorm()
//class TaskStatusTransNorm(val statusNorm: StatusNorm) : TransNorm()
//class TaskProgressTransNorm(val currentNorm: Long, val totalNorm: Long, val description: String) : TransNorm()
//enum class StatusNorm {
//    START, PAUSE, RESUME, STOP, EXIT, COMPLETE
//}
//
///**
// * Row 传输格式
// *
// * （1）type 字段：
// *
// * 新增 Tag 和 KeywordHits【关键字命中次数】类型，是 Row 中 UnknownType 类型的映射
// *
// * 新增 Number 类型，所有 数字类型 将被反序列化为 Long 或 Double 类型处理
// *
// * 二进制数据是否序列化通过参数控制， Byte 类型、UnknownType 类型的 Self 列，忽略序列化
// *
// * （2）metadata 字段：
// *
// * 等同于 Row 中 MetaData 中的 source
// *
// * 只接受 数字、字符串、布尔类型 的数据，如果新增其他类型，需要依照 data 字段自定义序列化和反序列化器
// *
// * （3）data 字段：
// *
// * 二进制的编码格式是 Base64字符串，BinariesType类型的数据，以 List<Pair<String,Base64>> 的形式存放
// *
// * （4）从第三方构造 RowTransmission：
// *
// *  一切 空集合、null 允许省略
// *
// *  开头必须提供 RowNorm 字节数组的长度 【 Int as ByteArray(4) 】
// **/
//data class RowNorm(
//    val fieldNormList: List<FieldNorm>
//)
//
//@JsonSerialize(using = FieldNormSerializer::class)
//@JsonDeserialize(using = FieldNormDeSerializer::class)
//data class FieldNorm(
//    val name: String, val columnIsMeta: Boolean, val type: TypeEnum, val metaData: List<MetaDataNorm>, val data: Any?
//)
//
///**
// * 数据类型枚举
// * */
//enum class TypeEnum {
//    TagType, KeywordHits, NumberType, BooleanType, StringType, BinaryType, BinariesType
//}
//
///**
// * MetaData 数据规范
// * */
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "metaDataType")
//sealed class MetaDataNorm
//class SizeMetaData(val size: Long) : MetaDataNorm()
//class OmitDataMetaData(val omitData: Boolean) : MetaDataNorm()
//class PrimaryKeyMetaData(val primaryKey: Boolean) : MetaDataNorm()
//class TypeNameMetaData(val typeName: String) : MetaDataNorm()
//
///**
// * Tag 规范
// * */
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tagType")
//sealed class TagNorm
//
///**
// * 身份证号  ==>  原始路径 -- 匹配到的值 -- 索引范围
// * */
//class IdNumberTag(val path: String, val text: String, val range: IntRange) : TagNorm()
//
///**
// * 电话/手机号  ==>  原始路径 -- 匹配到的值 -- 索引范围
// * */
//class TelNumberTag(val path: String, val text: String, val range: IntRange) : TagNorm()
//
///**
// * 文件路径  ==>  原始路径 -- 文件名 -- 匹配到的值 -- 索引范围
// * */
//class PathTag(val path: String, val fieldName: String, val text: String, val range: IntRange) : TagNorm()
//
///**
// * 邮件  ==>  原始路径 -- 匹配到的值 -- 索引范围
// * */
//class EmailTag(val path: String, val text: String, val range: IntRange) : TagNorm()
//
//
///**
// * 特征白名单 ==>  原始路径 -- 特征值 -- 相似度
// * */
//class FeatureWhiteTag(val path: String, val feature: String, val similarity: Double) : TagNorm()
//
///**
// * 特征黑名单 ==>  原始路径 -- 特征值 -- 相似度
// * */
//class FeatureBlackTag(val path: String, val feature: String, val similarity: Double) : TagNorm()
//
//
///**
// * 红头文件 ==>  ”原始路径/文件名“
// * */
//class RedHeadTag(val pathWithName: String) : TagNorm()
//
//
///**
// * 疑似涉密 ==>  原始路径 -- 疑似涉密分数 -- 安全等级
// * */
//class SecurityTag(
//    val path: String, val score: Int, val safetyLevel: SafetyLevel
//) : TagNorm()
//
//
///**
// * 高密低存 ==>  原始路径 -- 安全等级描述
// * */
//class SecurityNoMatchTag(val path: String, val safetyLevelDescription: String) : TagNorm()
//
//
///**
// * 精确黑名单 ==>  ”原始路径/文件名“
// * */
//class PreciseBlackTag(val pathWithName: String) : TagNorm()
//
///**
// * 精确白名单 ==>  ”原始路径/文件名“
// * */
//class PreciseWhiteTag(val pathWithName: String) : TagNorm()
//
///**
// * 加密文件  ==>  原始路径
// * */
//class EncFileTag(val path: String) : TagNorm()
//
//
///**
// * 密标文件  ==>  原始路径
// * */
//class LabelFileTag(val path: String) : TagNorm()
//
//
///**
// * 文件夹带-拼接  ==>  原始路径
// * */
//class AppendFileTag(val path: String) : TagNorm()
//
//
///**
// * 文件夹带-内嵌  ==>  原始路径
// * */
//class InEmbedFileTag(val path: String) : TagNorm()
//
//
///**
// * 文件夹带-外嵌 ==>  原始路径
// * */
//class OutEmbedFileTag(val path: String) : TagNorm()
//
//
//enum class SafetyLevel {
//    Public, Inner, Mimi, Jimi, Juemi, Unknown
//}
