package ir.training.marvelcomics.util

import androidx.annotation.StringRes
import ir.training.marvelcomics.R

enum class Screen(@StringRes val title: Int) {
    ComicList(title = R.string.comic_list_screen),
    ComicItem(title = R.string.comic_item_screen),
}