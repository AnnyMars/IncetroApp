package com.example.incetroapp.presentation.mainscreen.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.incetroapp.ui.theme.AppAccentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(onActionClick: () -> Unit, count: Int, isSelected: Boolean) {
    TopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.Center,
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Рестораны",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 22.sp,
                        fontWeight = FontWeight(600),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = Color.White,
            navigationIconContentColor = Color.Black
        ),
        actions = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.clickable { onActionClick() }
            ) {
                Icon(
                    imageVector = if (isSelected) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                    tint = AppAccentColor,
                    modifier = Modifier.size(30.dp)
                )


                Text(
                    text = "$count",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(590),
                        color = if (isSelected) Color.White else AppAccentColor,
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true)
@Composable
fun Preview() {
    AppTopBar(onActionClick = { TODO() }, count = 1, isSelected = true)
}