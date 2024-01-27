package ir.training.marvelcomics.data.service.dto.db.comic

import ir.training.marvelcomics.domain.model.ComicItem

class ComicItemAdapterToComicDBbItem {

    fun map(comicResponse: ComicItem): ComicDbItem {
        return ComicDbItem(
            id = comicResponse.id,
            title = comicResponse.title,
            description = comicResponse.description,
            coverUrl = comicResponse.coverUrl,
        )
    }

}