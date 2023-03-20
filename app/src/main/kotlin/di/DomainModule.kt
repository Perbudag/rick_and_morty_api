package di

import dagger.Module
import dagger.Provides
import domain.repository.RickAndMortyRepository
import domain.usecase.repository.rick_and_morty.*
import javax.inject.Singleton

@Module
class DomainModule {
    @Provides
    @Singleton
    fun provideGetAllCharactersUseCase(repository: RickAndMortyRepository): GetAllCharactersUseCase {
        return GetAllCharactersUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetAllEpisodesUseCase(repository: RickAndMortyRepository): GetAllEpisodesUseCase {
        return GetAllEpisodesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetAllLocationsUseCase(repository: RickAndMortyRepository): GetAllLocationsUseCase {
        return GetAllLocationsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCharactersUseCase(repository: RickAndMortyRepository): GetCharactersUseCase {
        return GetCharactersUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCharacterUseCase(repository: RickAndMortyRepository): GetCharacterUseCase {
        return GetCharacterUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetEpisodesUseCase(repository: RickAndMortyRepository): GetEpisodesUseCase {
        return GetEpisodesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetEpisodeUseCase(repository: RickAndMortyRepository): GetEpisodeUseCase {
        return GetEpisodeUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetLocationsUseCase(repository: RickAndMortyRepository): GetLocationsUseCase {
        return GetLocationsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetLocationUseCase(repository: RickAndMortyRepository): GetLocationUseCase {
        return GetLocationUseCase(repository)
    }
}