package com.example.incetroapp.presentation.detailscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.incetroapp.data.models.Restaurant
import com.example.incetroapp.presentation.detailscreen.common.DetailTopBar
import com.example.incetroapp.presentation.detailscreen.common.RatingBar
import com.example.incetroapp.ui.theme.AppAccentColor

@Composable
fun DetailScreen(restaurant: Restaurant, navigateBack: () -> Unit) {
    val context = LocalContext.current
    val images = restaurant.photos
    val pagerState = rememberPagerState(initialPage = 0) {
        images.size
    }

    val text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight(400),
                color = Color.Gray
            )
        ) {
            append("Aster Bakery — это кафе-пекарня с открытой кухней, где посетители могут наблюдать за процессом приготовления хлеба и выпечки.")
        }
        withStyle(
            style = SpanStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight(400),
                color = Color.Gray
            )
        ) {
            append("\n\nМеню включает в себя разнообразные завтраки, такие как скрэмбл, вареные яйца и авокадо-тосты, а также основное меню с блюдами, такими как ризотто и капкейки. Гости высоко оценивают выпечку, особенно шоколадный торт и краффин. Цены в кафе средние.")
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF2F2F7))
    ) {
        DetailTopBar {
            navigateBack()
        }
        HorizontalPager(state = pagerState) { image: Int ->
            val imageUrl = images[image]
            AsyncImage(
                modifier = Modifier
                    .aspectRatio(14f / 8f)
                    .clip(RoundedCornerShape(15)),
                model = ImageRequest.Builder(context).data(imageUrl).build(),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(30))
                .padding(horizontal = 13.dp, vertical = 10.dp)
        ) {
            Row {
                Text(
                    text = restaurant.name,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = Color.Black
                    ),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = if (restaurant.isFavorite) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "",
                    tint = AppAccentColor
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                RatingBar(rating = restaurant.rate)
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "€ 30",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight(400),
                        color = Color.Gray
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(15))
                .padding(15.dp)
        ) {
            Text(
                text = "Описание", style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight(700),
                    color = Color.Black
                ),
                modifier = Modifier.padding(start = 5.dp)
            )

            Text(text = text, modifier = Modifier.padding(start = 5.dp, end = 20.dp))
        }

    }
}