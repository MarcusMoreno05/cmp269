package com.example

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

// Exercise 1
fun Route.exercise1() {
    get("/") {
        call.respondText("Server is online at Lehman College.")
    }
}

// Exercise 2
fun Route.exercise2() {
    get("/greet/{name}") {
        val name = call.parameters["name"] ?: "Guest"
        call.respondText("Hello, $name! Welcome to CMP 269.")
    }
}

// Exercise 3
fun Route.exercise3() {
    val grades = mapOf("123" to 95, "456" to 82)

    get("/grade/{studentId}") {
        val id = call.parameters["studentId"]
        val grade = grades[id]

        if (grade != null) {
            call.respondText("Student $id has a grade of $grade.")
        } else {
            call.respond(HttpStatusCode.NotFound, "Student not found")
        }
    }
}

// Exercise 4 worked
fun Route.exercise4() {
    staticResources("/static", "static")
}

// Exercise 5
@Serializable
data class Stock(val symbol: String, val price: Double)
//Error message:
//Serializer for class 'Stock' is not found.
//Please ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.
fun Route.exercise5() {
    get("/api/stock/{symbol}") {
        val symbol = call.parameters["symbol"] ?: "UNKNOWN"
        call.respond(Stock(symbol, 150.25))
    }
}

//routing function
fun Application.configureRouting() {
    routing {
        exercise1()
        exercise2()
        exercise3()
        exercise4()
        exercise5()
    }
}

