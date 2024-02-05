package ir.training.marvelcomics.main.view.widgets.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ir.training.marvelcomics.R

@Composable
fun GridListLoadMore(
    modifier: Modifier = Modifier,
    lazyVerticalGrid: @Composable () -> Unit,
    itemCount: Int = 0,
    showLoading: Boolean,
) {
    if (itemCount == 0) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!showLoading) {
                Text(
                    text = stringResource(id = R.string.no_item_found),
                    color = colorResource(id = R.color.text_color_primary),
                    fontSize = dimensionResource(id = R.dimen.font_size_large).value.sp,
                    fontWeight = FontWeight.Bold,
                )
            } else {
                CircularProgressIndicator(
                    color = colorResource(id = R.color.text_color_primary),
                    modifier = modifier.requiredSize(
                        dimensionResource(id = R.dimen.progress_size),
                        dimensionResource(id = R.dimen.progress_size)
                    )
                )
            }
        }
    } else {
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            lazyVerticalGrid.invoke()
            if (showLoading) {
                Box(
                    modifier = modifier
                        .size(
                            dimensionResource(id = R.dimen.progress_size),
                            dimensionResource(id = R.dimen.progress_size)
                        )
                        .background(
                            color = colorResource(id = R.color.page_background),
                            shape = CircleShape
                        )
                        .padding(dimensionResource(id = R.dimen.padding_small))
                        .align(Alignment.BottomCenter)
                ) {
                    CircularProgressIndicator(
                        color = colorResource(id = R.color.text_color_primary),
                        modifier = modifier
                            .padding(dimensionResource(id = R.dimen.padding_small))
                    )
                }
            }
        }
    }
}