package com.example.todo.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

/**
 * Project        : mvc
 * DATE           : 2023/03/10
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/03/10      dnejdzlr2          최초 생성
 */
data class ErrorResponse(
    @field:JsonProperty("result_code")
    var resultCode: String? = null,

    @field:JsonProperty("http_status")
    var httpStatus: String? = null,

    @field:JsonProperty("http_method")
    var httpMethod: String? = null,

    var message: String? = null,
    var path: String? = null,
    var timestamp: LocalDateTime? = null,
    var errors: MutableList<Error>? = mutableListOf()
)

data class Error(
    var filed: String? = null,
    var message: String? = null,
    var value:Any?= null
)
