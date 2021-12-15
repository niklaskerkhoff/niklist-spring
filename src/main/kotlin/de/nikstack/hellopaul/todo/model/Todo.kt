package de.nikstack.hellopaul.todo.model

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Todo(
    id: UUID?,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val description: String,

    @Column(nullable = false)
    val completed: Boolean = false,
) : IdEntity(id)
