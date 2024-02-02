package ir.training.marvelcomics.main.view.widgets.list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.log

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