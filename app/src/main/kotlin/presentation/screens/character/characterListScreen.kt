package presentation.screens.character

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun characterScreen(
    vm: CharacterListViewModel
) {
    val state by vm.state
    val page by vm.page

    val columnScope = rememberCoroutineScope()


    val gridState = rememberLazyGridState()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(200.dp),
        state = gridState,
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(state) {
            val image: Painter = if (it.image.value != null) {
                BitmapPainter(it.image.value!!)
            } else {
                painterResource("2.png")
            }

            characterCardItem(
                image = image,
                name = it.character.name,
                status = it.character.status,
                species = it.character.species
            ) {

            }

        }

        if (page == 1 || gridState.layoutInfo.visibleItemsInfo.isNotEmpty() &&
            gridState.layoutInfo.visibleItemsInfo.last().index > gridState.layoutInfo.totalItemsCount - 20
        ) {
            columnScope.launch {
                vm.getCharacters()
            }
        }
    }
}