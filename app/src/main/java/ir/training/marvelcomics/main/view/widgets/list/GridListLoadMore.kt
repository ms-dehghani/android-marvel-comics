package ir.training.marvelcomics.main.view.widgets.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GridListLoadMore(
    lazyVerticalGrid: @Composable () -> Unit,
    itemCount: Int = 0,
    showLoading: Boolean,
    modifier: Modifier = Modifier
) {
    if (itemCount == 0) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!showLoading) {
                Text(text = "No items found!")
            } else {
                CircularProgressIndicator(modifier = modifier.requiredSize(48.dp, 48.dp))
            }
        }
    } else {
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            lazyVerticalGrid.invoke()
            if (showLoading) {
                CircularProgressIndicator(
                    modifier = modifier
                        .requiredSize(48.dp, 48.dp)
                        .align(Alignment.BottomCenter)
                )
            }
        }
    }
}