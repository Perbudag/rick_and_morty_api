package di

import dagger.Component
import presentation.screens.character.CharacterListViewModel
import presentation.screens.main.MainViewModel
import javax.inject.Singleton

@Component(modules = [DataModule::class, DomainModule::class])
@Singleton
interface AppComponent {
    val mainViewModel: MainViewModel
    val characterListViewModel: CharacterListViewModel
}