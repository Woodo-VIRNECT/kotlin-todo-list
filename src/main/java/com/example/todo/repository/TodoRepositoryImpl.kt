package com.example.todo.repository

import com.example.todo.database.Todo
import com.example.todo.database.TodoDataBase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
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
@Service
class TodoRepositoryImpl : TodoRepository {

    @Autowired
    lateinit var todoDataBase: TodoDataBase

    override fun save(todo: Todo): Todo? {

        return todo.index?.let {index ->
            // update
            findOne(index)?.apply {
                this.title = todo.title
                this.description = todo.description
                this.schedule = todo.schedule
                this.createdAt = LocalDateTime.now()
                this.updatedAt = LocalDateTime.now()
            }
        }?: kotlin.run {
            // insert
            todo.apply {
                this.index = ++todoDataBase.index
                this.createdAt = LocalDateTime.now()
                this.updatedAt = LocalDateTime.now()
            }.run {
                todoDataBase.todoList.add(todo)
                this
            }
        }
    }

    override fun saveAll(todoList: MutableList<Todo>): Boolean {
        return try {
            todoList.forEach {
                save(it)
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override fun delete(index: Int): Boolean {
        val todo = findOne(index)

        return todo?.let {
            todoDataBase.todoList.remove(it)
            true
        } ?: kotlin.run {
            false
        }
    }

    override fun findOne(index: Int): Todo? {
        return todoDataBase.todoList.first { it.index == index }
    }

    override fun findAll(): MutableList<Todo> {
        return todoDataBase.todoList
    }
}