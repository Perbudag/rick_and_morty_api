package presentation.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import data.remove.RickAndMortyApi
import data.remove.client.httpClientInit
import data.repository.RickAndMortyRepositoryImpl
import domain.models.Character
import domain.repository.RickAndMortyRepository
import kotlinx.coroutines.launch

@Composable
fun mainScreen(vm: MainViewModel) {
    vm.initCoroutineScope(rememberCoroutineScope())

    val characters by vm.characters

    Button(onClick = {
        vm.updateCharacters()
    }) {
        Text(text = characters.size.toString())
    }
}