package com.concur.academy

import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
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
            val f = File("expenses.txt")
            val json = Json(JsonConfiguration.Stable)
            val storedExpenses: List<Expense> = try {
                json.parse(Expense.serializer().list, f.readLines().joinToString())
            } catch (t:Throwable) {
                listOf()
            }
            val newlyStoredExpenses = storedExpenses + expense
            f.writeText(json.stringify(Expense.serializer().list, newlyStoredExpenses))
            call.respond(HttpStatusCode.Created, mapOf("id" to expense.id))
        }

        get("/expenses") {
            val f = File("expenses.txt")
            val json = Json(JsonConfiguration.Stable)
            val storedExpenses: List<Expense> = try {
                json.parse(Expense.serializer().list, f.readLines().joinToString())
            } catch (t:Throwable) {
                listOf()
            }
            call.respond(storedExpenses)
        }

        get("/expenses/{expenseId}") {
            val expenseId = try {
                call.parameters["expenseId"]!!.toInt()
            } catch (t: Throwable) {
                return@get call.respond(HttpStatusCode.BadRequest)
            }
            val storedExpenses: List<Expense> = try {
                Json(JsonConfiguration.Stable)
                        .parse(Expense.serializer().list, File("expenses.txt").readLines().joinToString())
            } catch (t: Throwable) {
                return@get call.respond(HttpStatusCode.InternalServerError)
            }
            storedExpenses.forEach { expense ->
                if (expense.id == expenseId) {
                    return@get call.respond(expense)
                }
            }
            call.respond(HttpStatusCode.NotFound)
        }

        put("/expenses/{expenseId}") {
            val updatedExpense: Expense
            try {
                updatedExpense = call.receive()
                updatedExpense.id = call.parameters["expenseId"]!!.toInt()
            } catch (t: Throwable) {
                return@put call.respond(HttpStatusCode.BadRequest)
            }
            val storedExpenses: List<Expense> = try {
                Json(JsonConfiguration.Stable)
                        .parse(Expense.serializer().list, File("expenses.txt").readLines().joinToString())
            } catch (t: Throwable) {
                return@put call.respond(HttpStatusCode.InternalServerError)
            }
            storedExpenses.forEach { expense ->
                if (expense.id == updatedExpense.id) {
                    val newlyStoredExpenses = storedExpenses - expense + updatedExpense
                    File("expenses.txt").writeText(
                            Json(JsonConfiguration.Stable).stringify(Expense.serializer().list, newlyStoredExpenses)
                    )
                    return@put call.respond(HttpStatusCode.NoContent)
                }
            }
            call.respond(HttpStatusCode.NotFound)
        }

        delete("/expenses/{expenseId}") {
            val expenseId = try {
                call.parameters["expenseId"]!!.toInt()
            } catch (t: Throwable) {
                return@delete call.respond(HttpStatusCode.BadRequest)
            }
            val storedExpenses: List<Expense> = try {
                Json(JsonConfiguration.Stable)
                        .parse(Expense.serializer().list, File("expenses.txt").readLines().joinToString())
            } catch (t: Throwable) {
                return@delete call.respond(HttpStatusCode.InternalServerError)
            }
            for (expense in storedExpenses) {
                if (expense.id == expenseId) {
                    val newlyStoredExpenses = storedExpenses - expense
                    File("expenses.txt").writeText(
                            Json(JsonConfiguration.Stable).stringify(Expense.serializer().list, newlyStoredExpenses)
                    )
                    break
                }
            }
            return@delete call.respond(HttpStatusCode.NoContent)
        }
    }

}
