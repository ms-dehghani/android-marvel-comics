package ir.training.marvelcomics.main.view.widgets.item

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
fun EmptyView(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            text = stringResource(id = R.string.no_item_found),
            color = colorResource(id = R.color.text_color_primary),
            fontSize = dimensionResource(id = R.dimen.font_size_large).value.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.align(Alignment.Center)
        )
    }
}