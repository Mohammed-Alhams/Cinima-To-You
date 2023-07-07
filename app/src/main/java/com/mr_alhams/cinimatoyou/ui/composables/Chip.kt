package com.mr_alhams.cinimatoyou.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mr_alhams.cinimatoyou.ui.theme.OpenSans

@Composable
fun Chip(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        modifier
            .border(
                shape = RoundedCornerShape(16.dp),
                width = 1.dp,
                color = Color.LightGray,
            )
            .padding(vertical = 4.dp, horizontal = 8.dp),
        fontFamily = OpenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
}