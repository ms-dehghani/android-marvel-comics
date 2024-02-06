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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ir.training.marvelcomics.R
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.util.helper.image.ImageHelper
import ir.training.marvelcomics.util.helper.image.ImageSize

@Composable
fun ComicItemView(
    comic: ComicItem?, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .background(color = MaterialTheme.colorScheme.background)
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
                    .padding(dimensionResource(id = R.dimen.page_padding))
            ) {
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = comic.title,
                    style = MaterialTheme.typography.headlineMedium,
                    color = colorResource(id = R.color.text_color_primary)
                )
                ExpandableText(
                    text = comic.description,
                    style = MaterialTheme.typography.labelLarge,
                    minimizedMaxLines = 3
                )
                Text(
                    modifier = Modifier.padding(top = 10.dp),
                    text = comic.publishedDate,
                    style = MaterialTheme.typography.labelMedium,
                    color = colorResource(id = R.color.text_color_secondary)
                )
                Text(
                    text = comic.writer,
                    style = MaterialTheme.typography.labelMedium,
                    color = colorResource(id = R.color.text_color_secondary)
                )
                Text(
                    text = comic.penciler,
                    style = MaterialTheme.typography.labelMedium,
                    color = colorResource(id = R.color.text_color_secondary)
                )
            }
        }
    }
}