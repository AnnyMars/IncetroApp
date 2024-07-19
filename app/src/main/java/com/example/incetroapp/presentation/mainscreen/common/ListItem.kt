package com.example.incetroapp.presentation.mainscreen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.incetroapp.R
import com.example.incetroapp.ui.theme.AppAccentColor

@Composable
fun HotelItem() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        Row(
            modifier = Modifier.padding(horizontal = 10.dp)
        ){
            Text(
                modifier = Modifier.weight(1f),
                text = "Piatsa Gourounaki ",
                style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight(510),
                    color = Color.Black,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Icon(

                imageVector = Icons.Default.Favorite,
                contentDescription = "",
                tint = AppAccentColor
            )

        }

    }
}


@Preview
@Composable
fun PreviewListItem() {
    HotelItem()
}