package domain.usecase.repository.rick_and_morty

import domain.models.Character
import domain.repository.RickAndMortyRepository

class GetCharacterUseCase(private val repository: RickAndMortyRepository) {
    suspend operator fun invoke(id: Int): Character {
        return repository.getCharacter(id)
    }
}