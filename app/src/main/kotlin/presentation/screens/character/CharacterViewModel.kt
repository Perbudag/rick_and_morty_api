package presentation.screens.character

import domain.usecase.repository.rick_and_morty.GetAllCharactersUseCase
import domain.usecase.repository.rick_and_morty.GetCharacterUseCase
import domain.usecase.repository.rick_and_morty.GetCharactersUseCase
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    val getAllCharactersUseCase: GetAllCharactersUseCase,
    val getCharactersUseCase: GetCharactersUseCase,
    val getCharacterUseCase: GetCharacterUseCase
) {
}