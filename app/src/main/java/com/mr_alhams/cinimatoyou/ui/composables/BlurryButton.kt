package com.mr_alhams.cinimatoyou.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun BlurryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    IconButton(
        onClick = { onClick() },
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    listOf(Color.LightGray, Color.White),
                ),
                alpha = 0.3f,
                shape = CircleShape
            )
    ) {
        content()
    }
}