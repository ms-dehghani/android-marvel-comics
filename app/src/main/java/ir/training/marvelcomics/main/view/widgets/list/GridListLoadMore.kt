package ir.training.marvelcomics.main.view.widgets.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.training.marvelcomics.main.state.base.PageState

@Composable
fun GridListLoadMore(
    items: List<@Composable () -> Unit>,
    onLoadMoreListener: () -> Unit,
    pageState: PageState,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyGridState()

    if (items.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (pageState != PageState.LOADING) {
                Text(text = "No comics found!")
            } else {
                CircularProgressIndicator(modifier = Modifier.requiredSize(48.dp, 48.dp))
            }
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                state = listState,
                modifier = modifier
            ) {
                items(items.size) { index ->
                    items[index].invoke()
                    if (index == items.size - 1 && pageState != PageState.LOADING) {
                        onLoadMoreListener.invoke()
                    }
                }
            }
            if (pageState == PageState.LOADING) {
                CircularProgressIndicator(modifier = Modifier.requiredSize(48.dp, 48.dp))
            }
        }
    }
}