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

    fun getById(todoId: UUID): Todo {
        return todoRepository.findById(todoId)
            .orElseThrow {
                ResponseStatusException(HttpStatus.NOT_FOUND)
            }
    }

    fun addTodo(todo: Todo): Todo {
        return todoRepository.save(todo)
    }

    fun updateTodo(todo: Todo): Todo {
        return todoRepository.save(todo)
    }

    fun deleteTodo(todoId: UUID) {
        todoRepository.deleteById(todoId)
    }
}