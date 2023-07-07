package com.mr_alhams.cinimatoyou.ui.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SpacerVertical32() {
    Spacer(modifier = Modifier.height(32.dp))
}

@Composable
fun SpacerVertical24() {
    Spacer(modifier = Modifier.height(24.dp))
}

@Composable
fun SpacerHorizontal() {
    Spacer(modifier = Modifier.width(8.dp))
}