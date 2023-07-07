package com.mr_alhams.cinimatoyou.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mr_alhams.cinimatoyou.ui.screens.theater.ShowDatesUIState
import com.mr_alhams.cinimatoyou.ui.theme.InitialChipBackground
import com.mr_alhams.cinimatoyou.ui.theme.OnBackGround
import com.mr_alhams.cinimatoyou.ui.theme.OpenSans

@Composable
fun ShowDateChip(
    showDatesUIState: ShowDatesUIState,
    isSelected: Boolean,
    onClick: () -> Unit
) {

    val backgroundColors = if (isSelected) listOf(
        Color.Gray,
        InitialChipBackground,
    ) else listOf(
        Color.White,
        Color.White,
    )

    val textColor = if (isSelected) Color.White else OnBackGround

    val shape = RoundedCornerShape(24.dp)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(shape)
            .background(
                brush = Brush.linearGradient(
                    colors = backgroundColors
                )
            )
            .clickable { onClick() }
            .border(1.dp, color = Color.LightGray, shape = shape)
            .padding(vertical = 16.dp, horizontal = 20.dp)
    ){
        Text(
            text = showDatesUIState.numberOfDay,
            fontFamily = OpenSans,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = textColor,
        )

        Text(
            text = showDatesUIState.dayOfWeek,
            fontFamily = OpenSans,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            color = textColor,
        )
    }
}