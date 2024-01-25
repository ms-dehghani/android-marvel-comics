package ir.training.marvelcomics.data.service.dto.comic

import ir.training.marvelcomics.data.service.dto.thumbnail.ThumbnailResponse

class ComicResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val thumbnail: ThumbnailResponse,
)