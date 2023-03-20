package domain.usecase.repository.rick_and_morty

import domain.models.Episode
import domain.repository.RickAndMortyRepository

class GetEpisodeUseCase(private val repository: RickAndMortyRepository) {
    suspend operator fun invoke(id: Int): Episode {
        return repository.getEpisode(
            id = id
        )
    }
}