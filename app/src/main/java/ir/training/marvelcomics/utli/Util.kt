package ir.training.marvelcomics.utli

import androidx.compose.runtime.Composable
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems

object Util {
    @Composable
    fun <T : Any> PagingData<T>.collectAsLazyPagingItems(): LazyPagingItems<T> {
        return collectAsLazyPagingItems()
    }
}