package com.mr_alhams.cinimatoyou.ui.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mr_alhams.cinimatoyou.ui.theme.OnPrimary
import com.mr_alhams.cinimatoyou.ui.theme.OpenSans
import com.mr_alhams.cinimatoyou.ui.theme.Orange

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Orange),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        content()
    }
}