package ir.training.marvelcomics.domain.model

data class Comic(
    val id: Int,
    val title: String,
    val coverUrl: String,
    val publishedDate: String,
    val writer: String,
    val penciler: String,
    val description: String
)
