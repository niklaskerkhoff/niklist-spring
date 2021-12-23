package de.nikstack.hellopaul.todo

import de.nikstack.hellopaul.todo.model.Todo
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TodoRepository : JpaRepository<Todo, UUID> {
    fun findAllByOrderByTitleAsc()
}