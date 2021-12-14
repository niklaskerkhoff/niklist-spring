package de.nikstack.hellopaul.todo

import de.nikstack.hellopaul.todo.model.Todo
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class TodoService(val todoRepository: TodoRepository) {

    fun getAll(): List<Todo> {
        return todoRepository.findAll()
    }

    fun getById(todoId: String): Todo {
        return todoRepository.findById(todoId) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun addTodo(todo: Todo): Todo {
        val newTodo = todo.copy(id = UUID.randomUUID().toString())
        return todoRepository.addTodo(newTodo) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun updateTodo(todo: Todo): Todo {
        return todoRepository.updateTodo(todo) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun deleteTodo(todoId: String) {
        todoRepository.deleteTodo(todoId)
    }
}