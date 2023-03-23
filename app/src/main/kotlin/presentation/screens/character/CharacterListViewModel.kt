package presentation.screens.character

import androidx.compose.runtime.mutableStateOf
import domain.usecase.repository.rick_and_morty.GetAllCharactersUseCase
import presentation.screens.character.models.CharacterState
import javax.inject.Inject

class CharacterListViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) {
    var isLoading = false
    var page = mutableStateOf(1)
        private set
    var state = mutableStateOf<List<CharacterState>>(listOf())
        private set

    fun clearState() {
        page.value = 1
        state.value = listOf()
    }

    suspend fun getCharacters() {
        if (!isLoading) {
            isLoading = true
            val oldState = if (state.value.isNotEmpty()) {
                state.value as MutableList<CharacterState>
            } else {
                mutableListOf()
            }
            page.value++
            oldState.addAll(getAllCharactersUseCase(page = page.value).map { CharacterState(it) })
            state.value = oldState
            isLoading = false
        }
    }
}