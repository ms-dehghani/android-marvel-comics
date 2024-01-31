package ir.training.marvelcomics.item.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ir.training.marvelcomics.main.view.item.components.AppBar

@Preview
@Composable
fun AppBarPreview() {
    AppBar(
        modifier = Modifier
            .fillMaxSize()
    )
}