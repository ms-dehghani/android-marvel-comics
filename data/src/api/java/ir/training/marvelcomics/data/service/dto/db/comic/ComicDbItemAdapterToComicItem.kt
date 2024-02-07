package ir.training.marvelcomics.data.service.dto.db.comic

import ir.training.marvelcomics.domain.model.ComicItem

class ComicDbItemAdapterToComicItem {

    fun map(comicDbItem: ComicDbItem): ComicItem {
        return ComicItem(
            id = comicDbItem.comicID,
            title = comicDbItem.title,
            description = comicDbItem.description,
            coverUrlPath = comicDbItem.coverUrlPath,
            coverUrlExtension = comicDbItem.coverUrlExtension,
            penciler = comicDbItem.penciler,
            publishedDate = comicDbItem.publishedDate,
            writer = comicDbItem.writer,
        )
    }

}