package com.example.incetroapp.presentation.detailscreen.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopBar(onBackClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Ресторан", style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight(600),
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                )
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = Color.White,
            navigationIconContentColor = Color.Black
        ),
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
            }
        }
    )
}
