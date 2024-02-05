package ir.training.marvelcomics.main.view.widgets.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(170.dp)
                .padding(0.dp, 30.dp, 0.dp, 0.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .background(color = Color.Blue)
                .clickable { onComicClicked(comicItem.id) },
        ) {
            Text(
                text = comicItem.title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 2,
                color = Color.White,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 20.dp, start = 160.dp, end = 10.dp)
            )
        }
        AsyncImage(
            model = ImageHelper.getThumbnailUrl(
                path = comicItem.coverUrlPath,
                extension = comicItem.coverUrlExtension,
                imageSize = ImageSize.FANTASTIC
            ),
            contentDescription = "Comic Cover ${comicItem.id}",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(15.dp, 0.dp, 0.dp, 15.dp)
                .width(130.dp)
                .aspectRatio(0.75f)
                .clip(shape = RoundedCornerShape(5.dp))
                .background(color = Color.LightGray)
                .clickable { onComicClicked(comicItem.id) },

            )
    }
}