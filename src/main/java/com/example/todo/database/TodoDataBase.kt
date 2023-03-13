package com.example.todo.database

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
data class TodoDataBase(
    var index: Int = 0,
    var todoList: MutableList<Todo> = mutableListOf()
) {
    fun init() {
        this.index = 0
        this.todoList = mutableListOf()
        println("[DEBUG] todo database init")
    }
}