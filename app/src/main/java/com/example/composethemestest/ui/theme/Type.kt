package com.example.composethemestest.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.composethemestest.R


val latoFontFamily = FontFamily(
    androidx.compose.ui.text.font.Font(R.font.lato_regular),
    androidx.compose.ui.text.font.Font(R.font.lato_medium, FontWeight.Medium),
    androidx.compose.ui.text.font.Font(R.font.lato_bold, FontWeight.Bold),
)

// Default Material 3 typography values
val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.labelSmall,
    displayMedium = baseline.labelSmall,
    displaySmall = baseline.labelSmall,
    headlineLarge = createTextStyle(
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Normal,
    ),
    headlineMedium = createTextStyle(
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Normal,
    ),
    headlineSmall = createTextStyle(
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Bold,
    ),
    titleLarge = createTextStyle(
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
        fontWeight = FontWeight.Normal,
    ),
    titleMedium = createTextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp,
        fontWeight = FontWeight.Medium,
    ),
    titleSmall = createTextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
        fontWeight = FontWeight.Medium,
    ),
    bodyLarge = createTextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Normal,
    ),
    bodyMedium = createTextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp,
        fontWeight = FontWeight.Normal,
    ),
    bodySmall = createTextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp,
        fontWeight = FontWeight.Normal,
    ),
    labelLarge = createTextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp,
        fontWeight = FontWeight.Medium,
    ),
    labelMedium = createTextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Medium,
    ),
    labelSmall = createTextStyle(
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Medium,
    ),
)

private fun createTextStyle(
    fontSize: TextUnit,
    fontWeight: FontWeight,
    letterSpacing: TextUnit,
    lineHeight: TextUnit,
): TextStyle {
    return TextStyle(
        fontSize = fontSize,
        lineHeight = lineHeight,
        fontWeight = fontWeight,
        letterSpacing = letterSpacing,
        fontFamily = latoFontFamily,
        platformStyle = PlatformTextStyle(),
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None,
        )
    )
}

