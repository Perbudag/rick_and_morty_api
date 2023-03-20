package presentation.screens.episode

import domain.usecase.repository.rick_and_morty.GetAllEpisodesUseCase
import domain.usecase.repository.rick_and_morty.GetEpisodeUseCase
import domain.usecase.repository.rick_and_morty.GetEpisodesUseCase
import javax.inject.Inject

class EpisodeViewModel @Inject constructor(
    val getAllEpisodesUseCase: GetAllEpisodesUseCase,
    val getEpisodesUseCase: GetEpisodesUseCase,
    val getEpisodeUseCase: GetEpisodeUseCase
) {
}