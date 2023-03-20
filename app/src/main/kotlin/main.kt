import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import di.DaggerAppComponent
import presentation.screens.main.MainViewModel
import presentation.screens.main.mainScreen

fun main() = application {

    val appComponent = DaggerAppComponent.create()
    val vm = appComponent.mainViewModel

    val x =
        Window(
            onCloseRequest = ::exitApplication,
            title = "Compose for Desktop",
            state = rememberWindowState(width = 300.dp, height = 300.dp)
        ) {
            MaterialTheme {
                mainScreen(vm)
            }
        }
}
