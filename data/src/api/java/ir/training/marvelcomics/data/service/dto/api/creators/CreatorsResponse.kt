package ir.training.marvelcomics.data.service.dto.api.creators

data class CreatorsResponse(
    val available: String,
    val items: List<CreatorItem>
)