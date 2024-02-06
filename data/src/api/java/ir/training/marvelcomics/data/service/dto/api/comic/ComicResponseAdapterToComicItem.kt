package ir.training.marvelcomics.data.service.dto.api.comic

import ir.training.marvelcomics.domain.model.ComicItem

class ComicResponseAdapterToComicItem {

    fun map(comicResponse: ComicResponse): ComicItem {
        return ComicItem(
            id = comicResponse.id,
            title = comicResponse.title,
            description = comicResponse.description ?: "",
            coverUrlPath = comicResponse.thumbnail.path,
            coverUrlExtension = comicResponse.thumbnail.extension,
            publishedDate = comicResponse.modified ?: "",
            writer = comicResponse.creators.items.firstOrNull { it.role == "writer" }?.name ?: "",
            penciler = comicResponse.creators.items.firstOrNull { it.role.contains("penciller") }?.name
                ?: ""
        )
    }

}