package ir.training.marvelcomics.domain.util

sealed class UIComponentType{

    object Dialog: UIComponentType()

    object None: UIComponentType()
}