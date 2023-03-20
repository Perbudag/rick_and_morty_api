package data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfoAndCharactersDto(
    @SerialName("info")
    val info: InfoDto?,
    @SerialName("results")
    val results: List<CharacterDto>?
)