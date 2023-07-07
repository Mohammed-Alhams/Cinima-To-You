package com.mr_alhams.cinimatoyou.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val titleMedium = TextStyle(
    fontFamily = OpenSans,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp
)

val bodySmall = TextStyle(
    fontFamily = OpenSans,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp
)

val titleLarge = TextStyle(
    fontFamily = OpenSans,
    fontWeight = FontWeight.Medium,
    fontSize = 24.sp,
    textAlign = TextAlign.Center,
    lineHeight = 32.sp,
)

val labelLarge = TextStyle(
    fontFamily = OpenSans,
    fontSize = 16.sp,
    fontWeight = FontWeight.Medium,
)

val labelSmall = TextStyle(
    fontFamily = OpenSans,
    fontSize = 12.sp,
    fontWeight = FontWeight.Medium
)

val spanLabelLarge = SpanStyle(
    fontFamily = OpenSans,
    fontSize = 16.sp,
    fontWeight = FontWeight.Medium,
)