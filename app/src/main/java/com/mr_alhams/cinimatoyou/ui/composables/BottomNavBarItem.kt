package com.mr_alhams.cinimatoyou.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.mr_alhams.cinimatoyou.ui.theme.OnBackGround
import com.mr_alhams.cinimatoyou.ui.theme.OnPrimary
import com.mr_alhams.cinimatoyou.ui.theme.Orange

@Composable
fun BottomNavBarItem(
    isSelected: Boolean,
    painter: Painter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val containerColor = if (isSelected) Orange else Color.Transparent
    val iconColor = if (isSelected) OnPrimary else OnBackGround
    Card(
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = containerColor),
        modifier = modifier
            .size(48.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick() }
        ) {
            Icon(
                painter = painter,
                contentDescription = null,
                tint = iconColor
            )
        }
    }
}