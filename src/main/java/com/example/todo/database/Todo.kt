package com.example.todo.database

import java.time.LocalDateTime

/**
 * Project        : todo
 * DATE           : 2023/03/13
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/03/13      dnejdzlr2          최초 생성
 */
data class Todo(
    var index: Int? = null,
    var title: String? = null,
    var description: String? = null,
    var schedule: LocalDateTime? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null,
)