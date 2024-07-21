package com.example.incetroapp.presentation.mainscreen.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.incetroapp.data.models.Data
import com.example.incetroapp.ui.theme.AppAccentColor

@Composable
fun RestaurantItem(model: Data, onFavoriteClick: (Data) -> Unit, onCardClick: () -> Unit) {

    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors().copy(containerColor = Color.White),
        onClick = { onCardClick() }
    ) {
        AsyncImage(
            modifier = Modifier.aspectRatio(16f / 8f),
            model = ImageRequest.Builder(context).data(model.photo).build(),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = model.name,
                style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight(510),
                    color = Color.Black,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            IconButton(onClick = { onFavoriteClick(model) }) {
                Icon(
                    imageVector = if (model.isFavorite) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "",
                    tint = AppAccentColor
                )
            }


        }

        Row(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "",
                tint = AppAccentColor,
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = model.rate.toString(), style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontWeight = FontWeight(400)
                )
            )
            Text(
                text = "€ 1000 ${model.cuisines.joinToString(", ")}",
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = TextStyle(
                    fontSize = 15.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight(400)
                ),
                modifier = Modifier
                    .padding(bottom = 2.dp, start = 5.dp)
                    .fillMaxWidth()
            )
        }

    }
}