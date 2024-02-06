package ir.training.marvelcomics.main.view.widgets.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ir.training.marvelcomics.R

@Composable
fun AppBar(
    onBackButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        IconButton(modifier = Modifier
            .wrapContentSize(align = Alignment.Center)
            .clip(CircleShape)
            .background(color = Color(0xFF18162e).copy(alpha = 0.2f)),
            onClick = { onBackButtonClicked() }) {
            Icon(
                modifier = Modifier.padding(start = 6.dp),
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "back",
                tint = Color.Unspecified
            )
        }
    }
}