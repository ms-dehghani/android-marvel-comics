package ir.training.marvelcomics.main.view.widgets.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.util.helper.ImageHelper
import ir.training.marvelcomics.util.helper.image.ImageSize

@Composable
fun ComicItemView(
    comic: ComicItem?, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .background(color = Color(0xFF18162e))
    ) {
        AsyncImage(
            model = ImageHelper.getThumbnailUrl(
                path = comic!!.coverUrlPath,
                extension = comic.coverUrlExtension,
                imageSize = ImageSize.FANTASTIC
            ),
            contentDescription = "Comic Cover ${comic.id}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .aspectRatio(0.8f)

        )
        Box(
            modifier = Modifier
                .padding(20.dp)
                .offset(y = -60.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .weight(1f)
                .background(color = Color(0xFF1c1c3b))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = comic.title,
                    style = MaterialTheme.typography.headlineLarge,
                    color = Color(0xFFfaf9ff)
                )
                ExpandableText(
                    text = comic.description,
                    style = MaterialTheme.typography.labelLarge,
                    minimizedMaxLines = 3
                )
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = comic.publishedDate,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color(0xFF565574)
                )
                Text(
                    text = comic.writer,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color(0xFF565574)
                )
                Text(
                    text = comic.penciler,
                    style = MaterialTheme.typography.labelLarge,
                    color = Color(0xFF565574)
                )
            }
        }
    }
}