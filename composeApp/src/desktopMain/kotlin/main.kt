import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.appModule
import di.viewmodelModule
import org.koin.core.context.GlobalContext.startKoin

fun main() = application {
    startKoin {
        modules(appModule, viewmodelModule)
    }
    Window(
        onCloseRequest = ::exitApplication,
        title = "bodegapp",
    ) {
        App()
    }
}