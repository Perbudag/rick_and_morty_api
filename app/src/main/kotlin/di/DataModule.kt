package di

import dagger.Module
import dagger.Provides
import data.remove.RickAndMortyApi
import data.remove.client.httpClientInit
import data.repository.RickAndMortyRepositoryImpl
import domain.repository.RickAndMortyRepository
import io.ktor.client.*
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return httpClientInit()
    }

    @Provides
    @Singleton
    fun providerRickAndMortyApi(client: HttpClient): RickAndMortyApi {
        return RickAndMortyApi(client)
    }

    @Provides
    @Singleton
    fun providerRickAndMortyRepository(api: RickAndMortyApi): RickAndMortyRepository {
        return RickAndMortyRepositoryImpl(api)
    }
}