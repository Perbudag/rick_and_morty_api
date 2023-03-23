package domain.repository.filters

import domain.models.Gender
import domain.models.Status

data class CharacterFilter(
    val page: Int? = null,
    val name: String? = null,
    val status: Status? = null,
    val species: String? = null,
    val type: String? = null,
    val gender: Gender? = null
)
