package de.nikstack.hellopaul.todo

import de.nikstack.hellopaul.replace
import de.nikstack.hellopaul.todo.model.Todo
import org.springframework.stereotype.Component

@Component
class TodoRepository {

    private var todos = listOf<Todo>()

    fun findAll(): List<Todo> {
        return todos
    }

    fun findById(todoId: String): Todo? {
        return todos.firstOrNull { it.id == todoId }
    }

    fun addTodo(todo: Todo): Todo? {
        todos = todos + todo
        return todo
    }

    fun updateTodo(todo: Todo): Todo? {
        val old = todos.firstOrNull { it.id == todo.id } ?: return null
        todos = todos.replace(old, todo)
        return todo
    }

    fun deleteTodo(todoId: String) {
        todos = todos.filter { it.id != todoId }
    }
}
