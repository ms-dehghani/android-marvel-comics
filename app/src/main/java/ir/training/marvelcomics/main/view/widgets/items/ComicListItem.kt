package ir.training.marvelcomics.main.view.widgets.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.utli.helper.ImageHelper
import ir.training.marvelcomics.utli.helper.image.ImageSize

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
        AsyncImage(
            model = ImageHelper.getThumbnailUrl(
                path = comicItem.coverUrlPath,
                extension = comicItem.coverUrlExtension,
                imageSize = ImageSize.FANTASTIC
            ),
            contentDescription = "Comic Cover ${comicItem.id}",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(200.dp)
                .aspectRatio(0.8f)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(color = androidx.compose.ui.graphics.Color.LightGray)

        )
        Text(
            text = comicItem.title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            maxLines = 2,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}