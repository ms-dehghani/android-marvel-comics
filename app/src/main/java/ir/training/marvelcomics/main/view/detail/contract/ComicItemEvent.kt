package ir.training.marvelcomics.main.view.detail.contract

sealed class ComicItemEvent {
    data object OnBackButtonClicked : ComicItemEvent()
}