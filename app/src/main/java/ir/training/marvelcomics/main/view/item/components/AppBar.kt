package ir.training.marvelcomics.main.view.item.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppBar(
    onBackButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        IconButton(onClick = { onBackButtonClicked() }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
        }
    }
}