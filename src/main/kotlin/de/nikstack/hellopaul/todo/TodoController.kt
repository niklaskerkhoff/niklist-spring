package de.nikstack.hellopaul.todo

import de.nikstack.hellopaul.todo.model.Todo
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
class TodoController(val todoService: TodoService) {

    @GetMapping
    fun getAll(): List<Todo> {
        return this.todoService.getAll()
    }

    @GetMapping("/{todoId}")
    fun getById(@PathVariable todoId: UUID): Todo {
        return todoService.getById(todoId)
    }

    @PostMapping
    fun addTodo(@RequestBody todo: Todo): Todo {
        return todoService.addTodo(todo)
    }

    @PutMapping
    fun updateTodo(@RequestBody todo: Todo): Todo {
        return todoService.updateTodo(todo)
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable todoId: UUID) {
        todoService.deleteTodo(todoId)
    }
}