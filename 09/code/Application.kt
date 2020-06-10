package com.concur.academy

import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.serialization.DefaultJsonConfiguration
import io.ktor.serialization.json
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.io.File

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(ContentNegotiation) {
        json(json = Json(DefaultJsonConfiguration.copy(prettyPrint = true)), contentType = ContentType.Application.Json)
    }

    routing {
        get("/hello_world") {
            call.respond("Hello world!")
        }

        get("/hello/{name}") {
            val name = call.parameters["name"]
            val title = call.request.queryParameters["title"]?.plus(" ") ?: ""
            call.respond("Hello $title$name!")
        }

        post("/hello") {
            val name = call.receiveText()
            if (name == "") {
                return@post call.respond(HttpStatusCode.BadRequest)
            }
            call.respond("Hello $name!")
        }

        post("/expenses") {
            val expense: Expense
            try {
                expense = call.receive()
            } catch (t: Throwable) {
                return@post call.respond(HttpStatusCode.BadRequest)
            }
            val json = Json(JsonConfiguration.Stable)
            val f = File("expenses.txt")
            val storedExpenses: List<Expense> = try {
                json.parse(Expense.serializer().list, f.readLines().joinToString())
            } catch (t: Throwable) {
                listOf()
            }
            val newStoredExpenses = storedExpenses + expense
            f.writeText(json.stringify(Expense.serializer().list, newStoredExpenses))
            call.respond(HttpStatusCode.Created, mapOf("id" to expense.id))
        }

        get("/expenses") {
            val json = Json(JsonConfiguration.Stable)
            val f = File("expenses.txt")
            val storedExpenses: List<Expense> = try {
                json.parse(Expense.serializer().list, f.readLines().joinToString())
            } catch (t: Throwable) {
                listOf()
            }
            call.respond(storedExpenses)
        }
    }

}

