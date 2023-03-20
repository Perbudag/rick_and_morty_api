package domain.models

data class Character(
    val id: Int,
    val name: String,
    val status: Status,
    val species: String,
    val type: String,
    val gender: Gender,
    val origin: CharacterLocation?,
    val location: CharacterLocation?,
    val image: String,
    val episode: List<String?>
)