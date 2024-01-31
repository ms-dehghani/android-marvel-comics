package ir.training.marvelcomics.main.view.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun AppBar(onBackButtonClicked: () -> Unit = {}) {
    Row(horizontalArrangement = Arrangement.Start) {
        IconButton(onClick = { onBackButtonClicked() }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
        }
    }
}