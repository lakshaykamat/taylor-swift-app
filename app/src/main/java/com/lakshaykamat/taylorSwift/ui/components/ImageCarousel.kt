package com.lakshaykamat.taylorSwift.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lakshaykamat.taylorSwift.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@Composable
fun ImageCarousel(images: List<Painter>, modifier: Modifier = Modifier) {
    val scrollIntervalMillis = 3000L // 3 seconds

    // CoroutineScope for handling auto-scrolling
    LaunchedEffect(Unit) {
        while (isActive) {
            delay(scrollIntervalMillis)
            // Scroll to the next item
        }
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            items(images) { image ->
                Box(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                ) {
                    Image(
                        painter = image,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(percent = 4))
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewImageCarousel() {
    val images = listOf<Painter>(
        // Replace these with your actual image resources or URLs
        //painterResource(id = R.drawable.taylor_shiny_legs),
        painterResource(id = R.drawable.jwell),
    )
    ImageCarousel(images = images)
}
