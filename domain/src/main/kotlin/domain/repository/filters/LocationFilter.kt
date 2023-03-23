package domain.repository.filters

data class LocationFilter(
    val page: Int? = null,
    val name: String? = null,
    val type: String? = null,
    val dimension: String? = null
)
