package ir.training.marvelcomics.main.view.widgets.list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import ir.training.marvelcomics.R
import ir.training.marvelcomics.main.view.widgets.item.EmptyView

@Composable
fun GridListLoadMore(
    modifier: Modifier = Modifier,
    lazyVerticalGrid: @Composable () -> Unit,
    itemCount: Int = 0,
    showLoading: Boolean,
) {
    if (itemCount == 0) {
        if (showLoading) {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    color = colorResource(id = R.color.text_color_primary),
                    modifier = modifier.requiredSize(
                        dimensionResource(id = R.dimen.progress_size),
                        dimensionResource(id = R.dimen.progress_size)
                    )
                )
            }
        } else
            EmptyView(modifier = modifier)
    } else {
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            lazyVerticalGrid.invoke()
            if (showLoading) {
                Box(
                    modifier = Modifier
                        .size(
                            dimensionResource(id = R.dimen.progress_size),
                            dimensionResource(id = R.dimen.progress_size)
                        )
                        .align(Alignment.BottomCenter)
                        .padding(dimensionResource(id = R.dimen.padding_small))
                        .background(
                            color = colorResource(id = R.color.page_background) , shape = CircleShape)
                ) {
                    CircularProgressIndicator(
                        color = colorResource(id = R.color.text_color_primary),
                        modifier = Modifier
                            .padding(dimensionResource(id = R.dimen.padding_small))
                    )
                }
            }
        }
    }
}