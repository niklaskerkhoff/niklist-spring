package de.nikstack.hellopaul.todo.model

data class Todo(
    val id: String?,
    val title: String,
    val description: String,
    val completed: Boolean = false,
)
