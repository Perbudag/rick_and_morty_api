package data.dto


import domain.models.Location
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("type")
    val type: String? = null,
    @SerialName("dimension")
    val dimension: String? = null,
    @SerialName("residents")
    val residents: List<String?>? = null,
    @SerialName("url")
    val url: String,
    @SerialName("created")
    val created: String
)

fun LocationDto.toLocation(): Location {
    return Location(
        id = this.id,
        name = this.name ?: "",
        type = this.type ?: "",
        dimension = this.dimension ?: "",
        residents = this.residents ?: listOf()
    )
}