package domain.usecase.repository.rick_and_morty

import domain.models.Location
import domain.repository.RickAndMortyRepository

class GetLocationUseCase(private val repository: RickAndMortyRepository) {
    suspend operator fun invoke(id: Int): Location {
        return repository.getLocation(
            id = id
        )
    }
}