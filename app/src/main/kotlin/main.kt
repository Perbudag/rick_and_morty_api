import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import di.DaggerAppComponent
import domain.models.Status
import presentation.screens.character.CharacterListViewModel
import presentation.screens.character.characterCardItem
import presentation.screens.character.characterScreen
import presentation.screens.main.MainViewModel
import presentation.screens.main.mainScreen
import java.awt.Dimension
import javax.inject.Inject

fun main() = application {

    val appComponent = DaggerAppComponent.create()

    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose for Desktop",
        state = rememberWindowState(width = 300.dp, height = 300.dp)
    ) {
        this.window.minimumSize = Dimension(500, 500)
        MaterialTheme {
            Surface {
                characterScreen(appComponent.characterListViewModel)
            }
        }
    }
}
