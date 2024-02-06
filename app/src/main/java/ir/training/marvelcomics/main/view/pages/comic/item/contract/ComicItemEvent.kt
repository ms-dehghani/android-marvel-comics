package ir.training.marvelcomics.main.view.pages.comic.item.contract

sealed class ComicItemEvent {
    data object OnBackButtonClicked : ComicItemEvent()
}