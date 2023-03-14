package com.example.todo.controller.api.todo

import com.example.todo.model.http.TodoDto
import com.example.todo.service.TodoService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Project        : todo
 * DATE           : 2023/03/14
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/03/14      dnejdzlr2          최초 생성
 */
@Api(description = "일정관리")
@RestController
@RequestMapping("/api/todo")
class TodoApiController(
    val todoService: TodoService
) {

    @ApiOperation(value = "일정확인", notes = "일정확인 API GET")
    @GetMapping(path = [""])
    fun read(
        @RequestParam(required = false) index: Int?): ResponseEntity<TodoDto> {
        index?.let {
            todoService.read(index)
        }?.let {
            return ResponseEntity.ok(it)
        } ?: kotlin.run {
            return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .header(HttpHeaders.LOCATION, "/api/todo/all")
                .build()
        }
    }

    @GetMapping(path = ["/all"])
    fun readAll(): MutableList<TodoDto> {
        return todoService.readAll()
    }

    @PostMapping(path = [""])
    fun create(@Valid @RequestBody todoDto: TodoDto): ResponseEntity<TodoDto?> {
        return ResponseEntity.ok(todoService.create(todoDto))
    }

    @PutMapping(path = [""])    // create = 201, update = 200
    fun update(@Valid @RequestBody todoDto: TodoDto): ResponseEntity<TodoDto?> {
        todoService.update(todoDto)?.let {
            return ResponseEntity.status(HttpStatus.OK).body(todoService.update(todoDto))
        } ?: kotlin.run {
            return ResponseEntity.status(HttpStatus.CREATED).body(todoService.update(todoDto))
        }
    }

    @DeleteMapping(path = ["/{index}"])
    fun delete(@PathVariable(name = "index") _index: Int): ResponseEntity<Any> {
        if (!todoService.delete(_index)){
            return ResponseEntity.status(500).build()
        }

        return ResponseEntity.ok().build()
    }
}