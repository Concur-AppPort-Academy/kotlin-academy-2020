package sample

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.utils.io.core.use
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

internal expect val ioDispatcher: CoroutineDispatcher

class NetworkClient {
    internal var client: () -> HttpClient = {
        HttpClient().config {
            install(JsonFeature)
        }
    }

    fun callHelloWorld(callback: (result: String) -> Unit) {
        GlobalScope.async(ioDispatcher) {
            client().use {
                val result = it.get<String>(urlString = "https://kotlin-test-app-10.herokuapp.com/hello_world")
                callback(result)
            }
        }
    }
}