package com.lakshaykamat.taylorSwift.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

/**
Renders image from internet
 */
@Composable
fun InternetImage(
    imageURL: String,
    imageDescription: String? = null,
    round: Dp = 4.dp,
    size: Dp
) {
    Box(
        modifier = Modifier
            .size(size)
            .clip(RoundedCornerShape(round))
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageURL),
            contentDescription = imageDescription,
            modifier = Modifier.fillMaxSize()
        )
    }
}