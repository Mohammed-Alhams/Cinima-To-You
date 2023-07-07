package com.mr_alhams.cinimatoyou.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.mr_alhams.cinimatoyou.ui.screens.theater.ShowTimeUIState

@Composable
fun ShowTimes(
    times: List<ShowTimeUIState>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
    ) {
        items(times) {
            ShowTimeChip(it, onClick)
        }
    }
}