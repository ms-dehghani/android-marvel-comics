package ir.training.marvelcomics.data.service.dto.api.comic

import ir.training.marvelcomics.data.service.dto.api.thumbnail.ThumbnailResponse

class ComicResponse(
    val id: Int,
    val title: String,
    val description: String?,
    val thumbnail: ThumbnailResponse,
)