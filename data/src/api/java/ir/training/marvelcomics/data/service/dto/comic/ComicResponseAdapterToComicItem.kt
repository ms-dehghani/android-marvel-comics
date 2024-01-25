package ir.training.marvelcomics.data.service.dto.comic

import ir.training.marvelcomics.domain.model.ComicItem

class ComicResponseAdapterToComicItem{

    fun map(comicResponse: ComicResponse): ComicItem {
        return ComicItem(
            id = comicResponse.id,
            title = comicResponse.title,
            description = comicResponse.description ?: "",
            coverUrl = comicResponse.thumbnail.path + "." + comicResponse.thumbnail.extension,
            publishedDate = "",
            writer = "",
            penciler = ""
        )
    }

}