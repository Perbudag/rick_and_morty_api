package data.remove

import data.dto.*
import domain.repository.filters.CharacterFilter
import domain.repository.filters.EpisodeFilter
import domain.repository.filters.LocationFilter
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class RickAndMortyApi(private val client: HttpClient) {

    private val HOST = "rickandmortyapi.com"

    //Character
    suspend fun getAllCharacters(filter: CharacterFilter? = null): InfoAndCharactersDto {
        val str = requestCharacter("", filter)
        return Json.decodeFromString(str)
    }

    suspend fun getCharacters(ids: List<Int>, filter: CharacterFilter? = null): List<CharacterDto> {
        var path = "/"
        for (id in ids) {
            path += "$id,"
        }
        return Json.decodeFromString(requestCharacter(path, filter))
    }

    suspend fun getCharacter(id: Int): CharacterDto {
        return Json.decodeFromString(requestCharacter("/$id"))
    }

    //Location
    suspend fun getAllLocations(filter: LocationFilter? = null): InfoAndLocationDto {
        return Json.decodeFromString(requestLocation("", filter))
    }

    suspend fun getLocations(ids: List<Int>, filter: LocationFilter? = null): List<LocationDto> {
        var path = "/"
        for (id in ids) {
            path += "$id,"
        }
        return Json.decodeFromString(requestLocation(path, filter))
    }

    suspend fun getLocation(id: Int): LocationDto {
        return Json.decodeFromString(requestLocation("/$id"))
    }

    //Episode
    suspend fun getAllEpisodes(filter: EpisodeFilter? = null): InfoAndEpisodeDto {
        return Json.decodeFromString(requestEpisode("", filter))
    }

    suspend fun getEpisodes(ids: List<Int>, filter: EpisodeFilter? = null): List<EpisodeDto> {
        var path = "/"
        for (id in ids) {
            path += "$id,"
        }
        return Json.decodeFromString(requestEpisode(path, filter))
    }

    suspend fun getEpisode(id: Int): EpisodeDto {
        return Json.decodeFromString(requestEpisode("/$id"))
    }

    private suspend fun requestCharacter(path: String, filter: CharacterFilter? = null): String {
        return client.get {
            url {
                protocol = URLProtocol.HTTPS
                host = HOST
                path("/api/character$path")
                if (filter != null) {
                    if (filter.name != null) parameter("name", filter.name)
                    if (filter.status != null) parameter("status", filter.status!!.name)
                    if (filter.species != null) parameter("species", filter.species)
                    if (filter.type != null) parameter("type", filter.type)
                    if (filter.gender != null) parameter("gender", filter.gender!!.name)
                }
            }
        }.body()
    }

    private suspend fun requestLocation(path: String, filter: LocationFilter? = null): String {
        return client.get {
            url {
                protocol = URLProtocol.HTTPS
                host = HOST
                path("/api/location$path")
                if (filter != null) {
                    if (filter.name != null) parameter("name", filter.name)
                    if (filter.type != null) parameter("type", filter.type)
                    if (filter.dimension != null) parameter("dimension", filter.dimension)
                }
            }

        }.body()
    }

    private suspend fun requestEpisode(path: String, filter: EpisodeFilter? = null): String {
        return client.get {
            url {
                protocol = URLProtocol.HTTPS
                host = HOST
                path("/api/episode$path")
                if (filter != null) {
                    if (filter.name != null) parameter("name", filter.name)
                    if (filter.episode != null) parameter("episode", filter.episode)
                }
            }
        }.body()
    }
}