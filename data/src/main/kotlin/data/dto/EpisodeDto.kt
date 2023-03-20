package data.dto


import domain.models.Episode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("air_date")
    val airDate: String? = null,
    @SerialName("episode")
    val episode: String? = null,
    @SerialName("characters")
    val characters: List<String?>? = null,
    @SerialName("url")
    val url: String,
    @SerialName("created")
    val created: String
)

fun EpisodeDto.toEpisode(): Episode {
    return Episode(
        id = this.id,
        name = this.name ?: "",
        air_date = this.airDate ?: "",
        episode = this.episode ?: "",
        characters = this.characters ?: listOf()
    )
}