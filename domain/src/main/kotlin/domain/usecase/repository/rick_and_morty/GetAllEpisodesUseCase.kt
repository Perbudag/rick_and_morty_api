package domain.usecase.repository.rick_and_morty

import domain.models.Episode
import domain.repository.RickAndMortyRepository
import domain.repository.filters.EpisodeFilter

class GetAllEpisodesUseCase(private val repository: RickAndMortyRepository) {
    suspend operator fun invoke(
        page: Int? = null,
        name: String? = null,
        episode: String? = null
    ): List<Episode> {
        return repository.getAllEpisodes(
            EpisodeFilter(
                page = page,
                name = name,
                episode = episode
            )
        )
    }
}