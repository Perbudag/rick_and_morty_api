package domain.usecase.repository.rick_and_morty

import domain.models.Episode
import domain.repository.RickAndMortyRepository
import domain.repository.filters.EpisodeFilter

class GetEpisodesUseCase(private val repository: RickAndMortyRepository) {
    suspend operator fun invoke(
        ids: List<Int>,
        name: String? = null,
        episode: String? = null
    ): List<Episode> {
        return repository.getEpisodes(
            ids = ids,
            filter = EpisodeFilter(
                name = name,
                episode = episode
            )
        )
    }
}