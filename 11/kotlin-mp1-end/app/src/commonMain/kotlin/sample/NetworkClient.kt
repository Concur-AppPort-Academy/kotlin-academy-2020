package sample

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import io.ktor.utils.io.core.use
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

internal expect val ioDispatcher: CoroutineDispatcher

class NetworkClient {

    //region INITIALIZATION
    internal val client: () -> HttpClient = {
        HttpClient().config {
            install(JsonFeature)
        }
    }

    fun getHelloWorld(callback: (result: String) -> Unit) {
        GlobalScope.launch(ioDispatcher) {
            client().use {
                val result = it.get<String>(urlString = "https://kotlin-test-app-10.herokuapp.com/hello_world")
                callback(result)
            }

        }

    }

    fun getExpenses(callback: (result: String) -> Unit) {
        GlobalScope.launch(ioDispatcher) {
            client().use {
                val result = it.get<List<Expense>>(urlString = "https://kotlin-test-app-10.herokuapp.com/expenses")
                callback("$result")
            }
        }
    }
}