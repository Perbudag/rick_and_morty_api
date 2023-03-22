package presentation.screens.character

import domain.usecase.repository.rick_and_morty.GetAllCharactersUseCase
import domain.usecase.repository.rick_and_morty.GetCharacterUseCase
import domain.usecase.repository.rick_and_morty.GetCharactersUseCase
import javax.inject.Inject

class CharacterListViewModel @Inject constructor(
    val getAllCharactersUseCase: GetAllCharactersUseCase
) {

}