package data.repository

import data.dto.toCharacter
import data.dto.toEpisode
import data.dto.toLocation
import data.remove.RickAndMortyApi
import domain.repository.filters.CharacterFilter
import domain.repository.filters.EpisodeFilter
import domain.repository.filters.LocationFilter
import domain.models.*
import domain.repository.RickAndMortyRepository

class RickAndMortyRepositoryImpl(private val api: RickAndMortyApi) : RickAndMortyRepository {

    //Character
    override suspend fun getAllCharacters(filter: CharacterFilter?): List<Character> {
        return api.getAllCharacters(filter).results?.map {
            it.toCharacter()
        } ?: listOf()
    }
    override suspend fun getCharacters(ids: List<Int>, filter: CharacterFilter?): List<Character> {
        return api.getCharacters(ids, filter).map {
            it.toCharacter()
        }
    }
    override suspend fun getCharacter(id: Int): Character {
        return api.getCharacter(id).toCharacter()
    }

    //Location
    override suspend fun getAllLocations(filter: LocationFilter?): List<Location> {
        return api.getAllLocations(filter).results?.map {
            it.toLocation()
        } ?: listOf()
    }
    override suspend fun getLocations(ids: List<Int>,filter: LocationFilter?): List<Location> {
        return api.getLocations(ids, filter).map {
            it.toLocation()
        }
    }
    override suspend fun getLocation(id: Int): Location {
        return api.getLocation(id).toLocation()
    }

    //Episode
    override suspend fun getAllEpisodes(filter: EpisodeFilter?): List<Episode> {
        return api.getAllEpisodes(filter).results?.map {
            it.toEpisode()
        } ?: listOf()
    }
    override suspend fun getEpisodes(ids: List<Int>,filter: EpisodeFilter?): List<Episode> {
        return api.getEpisodes(ids, filter).map {
            it.toEpisode()
        }
    }
    override suspend fun getEpisode(id: Int): Episode {
        return api.getEpisode(id).toEpisode()
    }

}