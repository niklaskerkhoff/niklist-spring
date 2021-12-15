package de.nikstack.hellopaul.todo.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

@MappedSuperclass
abstract class IdEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false, updatable = false)
    val id: UUID?,
) {
    constructor() : this(null)

    inline fun <reified T> copy(): T {
        val entityClass = T::class

        val properties = this::class.memberProperties
            .map {
                @Suppress("UNCHECKED_CAST")
                (it as KProperty1<Any, *>).get(this)
            }.reversed()

        properties.forEach { println(it) }
        entityClass.constructors.first().parameters.forEach { println(it) }

        return entityClass.constructors.first()
            .call(*properties.toTypedArray())
    }

    override fun toString(): String {
        return this.id.toString()
    }
}
