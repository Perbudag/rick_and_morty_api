package domain.usecase.repository.rick_and_morty

import domain.models.Character
import domain.models.Gender
import domain.models.Status
import domain.repository.RickAndMortyRepository
import domain.repository.filters.CharacterFilter

class GetCharactersUseCase(private val repository: RickAndMortyRepository) {
    suspend operator fun invoke(
        ids: List<Int>,
        name: String? = null,
        status: Status? = null,
        species: String? = null,
        type: String? = null,
        gender: Gender? = null
    ): List<Character> {
        return repository.getCharacters(
            ids = ids,
            filter = CharacterFilter(
                name = name,
                status = status,
                species = species,
                type = type,
                gender = gender
            )
        )
    }
}