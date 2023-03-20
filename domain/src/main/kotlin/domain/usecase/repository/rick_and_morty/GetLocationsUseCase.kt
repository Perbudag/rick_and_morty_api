package domain.usecase.repository.rick_and_morty

import domain.models.Location
import domain.repository.RickAndMortyRepository
import domain.repository.filters.LocationFilter

class GetLocationsUseCase(private val repository: RickAndMortyRepository) {
    suspend operator fun invoke(
        ids: List<Int>,
        name: String? = null,
        type: String? = null,
        dimension: String? = null
    ): List<Location> {
        return repository.getLocations(
            ids = ids,
            filter = LocationFilter(
                name = name,
                type = type,
                dimension = dimension
            )
        )
    }
}