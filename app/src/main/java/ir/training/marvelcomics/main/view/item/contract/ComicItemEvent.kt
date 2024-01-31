package ir.training.marvelcomics.main.view.item.contract

sealed class ComicItemEvent {
    data object OnBackButtonClicked : ComicItemEvent()
}