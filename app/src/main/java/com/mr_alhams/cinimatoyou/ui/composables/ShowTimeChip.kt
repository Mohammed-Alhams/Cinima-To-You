package com.mr_alhams.cinimatoyou.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mr_alhams.cinimatoyou.ui.screens.theater.ShowTimeUIState
import com.mr_alhams.cinimatoyou.ui.theme.InitialChipBackground
import com.mr_alhams.cinimatoyou.ui.theme.OnBackGround
import com.mr_alhams.cinimatoyou.ui.theme.OpenSans

@Composable
fun ShowTimeChip(
    state: ShowTimeUIState,
    onClick: () -> Unit
) {

    val backgroundColors = if (state.isSelected) listOf(
        Color.Gray,
        InitialChipBackground,
    ) else listOf(
        Color.White,
        Color.White,
    )

    val textColor = if (state.isSelected) Color.White else OnBackGround

    val shape = RoundedCornerShape(Int.MAX_VALUE.dp)

    Text(
        text = state.time,
        fontFamily = OpenSans,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = textColor,
        modifier = Modifier
            .clip(shape)
            .background(
                brush = Brush.linearGradient(
                    colors = backgroundColors
                )
            )
            .clickable { onClick() }
            .border(1.dp, color = Color.LightGray, shape = shape)
            .padding(vertical = 8.dp, horizontal = 8.dp)
    )
}