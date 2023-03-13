package com.example.todo.config

import com.example.todo.database.Todo
import com.example.todo.database.TodoDataBase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

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
@Configuration
class AppConfig {

    @Bean(initMethod = "init")
    fun todoDataBase(): TodoDataBase {
        return TodoDataBase()
    }
}