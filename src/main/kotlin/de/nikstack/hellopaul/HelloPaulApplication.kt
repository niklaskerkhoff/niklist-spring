package de.nikstack.hellopaul

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@SpringBootApplication
class HelloPaulApplication {
    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.allowedOrigins = listOf(
            "http://localhost:4200",
            "http://localhost:80",
            "http://localhost",
            "https://niklist.nikstack.de",
        )
        config.allowedHeaders = listOf(
            "Origin", "Content-Type", "Accept", "Authorization",
            "Access-Control-Allow-Origin"
        )
        config.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
        source.registerCorsConfiguration("/**", config)
        return CorsFilter(source)
    }
}

fun main(args: Array<String>) {
    runApplication<HelloPaulApplication>(*args)
}

fun <E> Iterable<E>.replace(old: E, new: E) = map { if (it == old) new else it }
