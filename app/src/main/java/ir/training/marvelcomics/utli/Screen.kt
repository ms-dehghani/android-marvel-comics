package ir.training.marvelcomics.utli

import androidx.annotation.StringRes
import ir.training.marvelcomics.R

enum class Screen(@StringRes val title: Int) {
    ComicList(title = R.string.comic_list_screen),
    ComicDetail(title = R.string.comic_detail_screen),
}