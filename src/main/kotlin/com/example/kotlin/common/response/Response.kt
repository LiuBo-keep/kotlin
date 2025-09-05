package com.example.kotlin.common.response

import com.example.kotlin.common.enums.ResponseCode

/**
 * @author  aidan.liu
 * @since   2025/9/5 16:29
 * @version 1.0
 */
data class Response(
        var code: ResponseCode? = null,
        var msg: String? = null,
        var data: Any? = null
) {
    companion object {
        fun ok(): ResponseBuilder {
            return ResponseBuilder()
                    .code(ResponseCode.SUCCESS)
                    .msg(ResponseCode.SUCCESS.message)
        }

        fun fail(): ResponseBuilder {
            return ResponseBuilder()
                    .code(ResponseCode.BAD_REQUEST)
                    .msg(ResponseCode.BAD_REQUEST.message)
        }
    }
}

/**
 * ResponseBuilder类用于构建响应对象。
 * 它允许通过链式调用设置响应的各个属性，并最终构建出一个完整的Response实例。
 */
class ResponseBuilder {
    private var code: ResponseCode? = null
    private var msg: String? = null
    private var data: Any? = null

    fun entry(data: Any?) = apply { this.data = data }

    fun code(code: ResponseCode) = apply { this.code = code }

    fun msg(msg: String) = apply { this.msg = msg }

    fun build(): Response {
        return Response(code, msg, data)
    }
}