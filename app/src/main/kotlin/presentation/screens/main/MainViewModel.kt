package presentation.screens.main

import androidx.compose.runtime.mutableStateOf
import domain.models.Character
import domain.repository.RickAndMortyRepository
import domain.usecase.repository.rick_and_morty.GetAllCharactersUseCase
import domain.usecase.repository.rick_and_morty.GetCharactersUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor() {
    private lateinit var coroutineScope: CoroutineScope
    var characters = mutableStateOf<List<Character>>(listOf())
        private set

    fun initCoroutineScope(coroutineScope: CoroutineScope) {
        this.coroutineScope = coroutineScope
    }

    fun updateCharacters() {
        //coroutineScope.launch {
        //    characters.value = getCharactersUseCase((1..826).toList())
        //}
    }

}