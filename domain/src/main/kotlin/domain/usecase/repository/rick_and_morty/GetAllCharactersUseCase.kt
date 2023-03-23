package domain.usecase.repository.rick_and_morty

import domain.models.Character
import domain.models.Gender
import domain.models.Status
import domain.repository.RickAndMortyRepository
import domain.repository.filters.CharacterFilter

class GetAllCharactersUseCase(private val repository: RickAndMortyRepository) {

    suspend operator fun invoke(
        page: Int? = null,
        name: String? = null,
        status: Status? = null,
        species: String? = null,
        type: String? = null,
        gender: Gender? = null
    ): List<Character> {
        return repository.getAllCharacters(
            CharacterFilter(
                page = page,
                name = name,
                status = status,
                species = species,
                type = type,
                gender = gender
            )
        )
    }
}