package domain.repository

import domain.models.*
import domain.repository.filters.CharacterFilter
import domain.repository.filters.EpisodeFilter
import domain.repository.filters.LocationFilter

interface RickAndMortyRepository {

    //Character
    suspend fun getAllCharacters(filter: CharacterFilter? = null): List<Character>
    suspend fun getCharacters(ids: List<Int>, filter: CharacterFilter? = null): List<Character>
    suspend fun getCharacter(id: Int): Character

    //Location
    suspend fun getAllLocations(filter: LocationFilter? = null): List<Location>
    suspend fun getLocations(ids: List<Int>, filter: LocationFilter? = null): List<Location>
    suspend fun getLocation(id: Int): Location

    //Episode
    suspend fun getAllEpisodes(filter: EpisodeFilter? = null): List<Episode>
    suspend fun getEpisodes(ids: List<Int>, filter: EpisodeFilter? = null): List<Episode>
    suspend fun getEpisode(id: Int): Episode
}