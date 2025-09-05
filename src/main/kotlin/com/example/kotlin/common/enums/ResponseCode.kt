package com.example.kotlin.common.enums

/**
 * @author  aidan.liu
 * @since   2025/9/5 16:27
 * @version 1.0
 */
enum class ResponseCode constructor(val code: Int, val message: String) {
    SUCCESS(200, "请求成功"),
    BAD_REQUEST(400, "客户端错误，请求参数错误"),
    UNAUTHORIZED(401, "未授权，需要身份验证"),
    FORBIDDEN(403, "禁止访问，权限不足"),
    NOT_FOUND(404, "资源未找到"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");
}