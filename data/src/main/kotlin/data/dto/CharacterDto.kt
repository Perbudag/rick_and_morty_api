package data.dto


import domain.models.Character
import domain.models.CharacterLocation
import domain.models.Gender
import domain.models.Status
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("status")
    val status: String? = null,
    @SerialName("species")
    val species: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("gender")
    val gender: String? = null,
    @SerialName("origin")
    val origin: OriginDto? = null,
    @SerialName("location")
    val location: CharacterLocationDto? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("episode")
    val episode: List<String?>? = null,
    @SerialName("url")
    val url: String,
    @SerialName("created")
    val created: String
)

fun CharacterDto.toCharacter(): Character {

    val _origin: CharacterLocation? = if (this.origin != null) {
        val id: Int? = if (!this.origin.url.isNullOrEmpty()) {
            this.origin.url.removePrefix("https://rickandmortyapi.com/api/location/")?.toInt() ?: 0
        } else {
            null
        }

        CharacterLocation(
            name = this.origin.name ?: "", id = id
        )
    } else {
        null
    }

    val _location: CharacterLocation? = if (this.location != null) {
        val id: Int? = if (!this.location.url.isNullOrEmpty()) {
            this.location.url.removePrefix("https://rickandmortyapi.com/api/location/")?.toInt() ?: 0
        } else {
            null
        }

        CharacterLocation(
            name = this.location.name ?: "", id = id
        )
    } else {
        null
    }

    val _status = when (this.status) {
        Status.Alive.name -> Status.Alive
        Status.Dead.name -> Status.Dead
        else -> Status.Unknown
    }

    val _gender = when (this.gender) {
        Gender.Female.name -> Gender.Female
        Gender.Male.name -> Gender.Male
        Gender.Genderless.name -> Gender.Genderless
        else -> Gender.Unknown
    }

    return Character(
        id = this.id,
        name = this.name ?: "",
        status = _status,
        species = this.species ?: "",
        type = this.type ?: "",
        gender = _gender,
        origin = _origin,
        location = _location,
        image = this.image ?: "",
        episode = this.episode ?: listOf()
    )
}