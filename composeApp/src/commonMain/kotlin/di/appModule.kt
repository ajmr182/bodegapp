package di

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.dsl.module

@OptIn(ExperimentalSerializationApi::class)
val appModule = module {
    single {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                Json {
                    isLenient = true
                    explicitNulls = false
                    ignoreUnknownKeys = true
                }
            }

            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        println(message)
                    }
                }
            }

            install(HttpTimeout) {
                connectTimeoutMillis = 5000
                requestTimeoutMillis = 5000
                socketTimeoutMillis = 5000
            }
        }
    }
}