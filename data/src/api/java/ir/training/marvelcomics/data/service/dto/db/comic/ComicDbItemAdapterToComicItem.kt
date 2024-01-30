package ir.training.marvelcomics.data.service.dto.db.comic

import ir.training.marvelcomics.domain.model.ComicItem

class ComicDbItemAdapterToComicItem {

    fun map(comicResponse: ComicDbItem): ComicItem {
        return ComicItem(
            id = comicResponse.id,
            title = comicResponse.title,
            description = comicResponse.description,
            coverUrlPath = comicResponse.coverUrlPath,
            coverUrlExtension = comicResponse.coverUrlExtension,
            penciler = "",
            publishedDate = "",
            writer = ""
        )
    }

}