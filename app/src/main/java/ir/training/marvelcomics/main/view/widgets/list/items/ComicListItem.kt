package ir.training.marvelcomics.main.view.widgets.list.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ir.training.marvelcomics.R
import ir.training.marvelcomics.domain.model.ComicItem
import ir.training.marvelcomics.util.helper.image.ImageHelper
import ir.training.marvelcomics.util.helper.image.ImageSize

@Composable
fun ComicListItem(
    comicItem: ComicItem,
    onComicClicked: (comicItem: ComicItem) -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.page_padding))
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.comic_list_image_width).times(1.2f))
                .padding(
                    top = dimensionResource(id = R.dimen.padding_large),
                )
                .clip(shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_radios_medium)))
                .background(color = colorResource(id = R.color.item_background))
                .clickable { onComicClicked(comicItem) },
        ) {
            Text(
                text = comicItem.title,
                fontWeight = FontWeight.Bold,
                fontSize = dimensionResource(id = R.dimen.font_size_small).value.sp,
                maxLines = 2,
                color = colorResource(id = R.color.text_color_primary),
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(
                    top = dimensionResource(id = R.dimen.padding_large),
                    start = dimensionResource(id = R.dimen.comic_list_image_width)
                            + (dimensionResource(id = R.dimen.padding_large) * 2),
                    end = dimensionResource(id = R.dimen.padding_large)
                )
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
                .padding(
                    start = dimensionResource(id = R.dimen.padding_large),
                    bottom = dimensionResource(id = R.dimen.padding_large)
                )
                .width(dimensionResource(id = R.dimen.comic_list_image_width))
                .aspectRatio(0.75f)
                .clip(shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_radios_small)))
                .background(color = Color.LightGray)
                .clickable { onComicClicked(comicItem) },
        )
    }
}