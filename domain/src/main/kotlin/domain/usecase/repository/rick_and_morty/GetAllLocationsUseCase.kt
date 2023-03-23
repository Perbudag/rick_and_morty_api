package domain.usecase.repository.rick_and_morty

import domain.models.Location
import domain.repository.RickAndMortyRepository
import domain.repository.filters.LocationFilter

class GetAllLocationsUseCase(private val repository: RickAndMortyRepository) {
    suspend operator fun invoke(
        page: Int? = null,
        name: String? = null,
        type: String? = null,
        dimension: String? = null
    ): List<Location> {
        return repository.getAllLocations(
            LocationFilter(
                page = page,
                name = name,
                type = type,
                dimension = dimension
            )
        )
    }
}