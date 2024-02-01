package ir.training.marvelcomics.main.view.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import ir.training.marvelcomics.domain.model.ComicItem

@Composable
fun ComicListItem(
    comicItem: ComicItem,
    onComicClicked: (id: Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onComicClicked(comicItem.id) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberImagePainter(data = comicItem.coverUrlPath),
            contentDescription = "Comic Cover",
            modifier = Modifier
                .size(200.dp)
                .clip(shape = RoundedCornerShape(15.dp))
        )
        Text(
            text = comicItem.title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = comicItem.publishedDate,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = comicItem.writer,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}