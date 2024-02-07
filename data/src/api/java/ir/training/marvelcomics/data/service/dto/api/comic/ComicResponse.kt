package ir.training.marvelcomics.data.service.dto.api.comic

import ir.training.marvelcomics.data.service.dto.api.creators.CreatorsResponse
import ir.training.marvelcomics.data.service.dto.api.thumbnail.ThumbnailResponse

class ComicResponse(
    val id: Int,
    val title: String,
    val description: String?,
    val modified: String?,
    val thumbnail: ThumbnailResponse,
    val creators: CreatorsResponse,
)