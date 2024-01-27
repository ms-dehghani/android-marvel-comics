package ir.training.marvelcomics.domain.model

data class ComicItem(
    val id: Int,
    val title: String,
    val coverUrlPath: String,
    val coverUrlExtension: String,
    val publishedDate: String,
    val writer: String,
    val penciler: String,
    val description: String
)
