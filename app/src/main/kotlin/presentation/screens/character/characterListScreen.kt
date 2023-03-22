package presentation.screens.character

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import domain.models.Status

@Composable
fun characterScreen(
    vm: CharacterListViewModel
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(200.dp)
    ) {
        items(23) {
            Box(modifier = Modifier.padding(5.dp)){
                characterCardItem(
                    image = painterResource("2.png"),
                    name = "Morty Smith",
                    status = Status.alive,
                    type = "Humanoid"
                ) {

                }
            }
        }
    }
}