package ir.trining.marvelcomics.main.view.widgets.list.view

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ir.training.marvelcomics.main.view.widgets.list.GridListLoadMore
import androidx.compose.material3.Text

@Preview
@Composable
fun GridListLoadMore_Loading_Preview() {
    GridListLoadMore(
        itemCount = 0,
        showLoading = true,
        lazyVerticalGrid = {}
    )
}

@Preview
@Composable
fun GridListLoadMore_EmptyList_Preview() {
    GridListLoadMore(
        itemCount = 0,
        showLoading = false,
        lazyVerticalGrid = {}
    )
}

@Preview
@Composable
fun GridListLoadMore_FullList_Preview() {
    GridListLoadMore(
        itemCount = 1,
        showLoading = false,
        lazyVerticalGrid = {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
            ) {
                items(
                    count = 1,
                ) { index ->
                    Text("test")
                }
            }
        }
    )
}

@Preview
@Composable
fun GridListLoadMore_FullList_WithLoading__Preview() {
    GridListLoadMore(
        itemCount = 1,
        showLoading = true,
        lazyVerticalGrid = {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
            ) {
                items(
                    count = 1,
                ) { index ->
                    Text("test")
                }
            }
        }
    )
}