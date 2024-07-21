package com.example.incetroapp.presentation.detailscreen.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.StarHalf
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.incetroapp.ui.theme.AppAccentColor

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double,
    starCount: Int = 5,
    starSize: Int = 16,
    starColor: Color = AppAccentColor
) {
    val filledStars = rating.toInt()
    val halfStars = if (rating - filledStars >= 0.5) 1 else 0
    val emptyStars = starCount - filledStars - halfStars

    Row(modifier = modifier) {
        repeat(filledStars) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Filled Star",
                tint = starColor,
                modifier = Modifier.size(starSize.dp)
            )
        }
        repeat(halfStars) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.StarHalf,
                contentDescription = "Half Star",
                tint = starColor,
                modifier = Modifier.size(starSize.dp)
            )
        }
        repeat(emptyStars) {
            Icon(
                imageVector = Icons.Filled.StarBorder,
                contentDescription = "Empty Star",
                tint = starColor,
                modifier = Modifier.size(starSize.dp)
            )
        }
    }
}