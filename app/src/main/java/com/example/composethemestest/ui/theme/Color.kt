package com.example.composethemestest.ui.theme

import androidx.compose.ui.graphics.Color

private fun getMissing(index: Int): Color {
    val bins = 4
    val binSize = 256 / bins

    val blue = index % bins
    val green = (index / bins) % bins
    val red = index / (bins * bins)

    return Color(
        red = (red * binSize) % 256,
        green = (green * binSize) % 256,
        blue = (blue * binSize) % 256,
    )
}


val primaryLight = Color(0xff3A1AFE)
val onPrimaryLight = Color(0xFFFFFFFF)
val secondaryContainerLight = Color(0xFFDCE3FC)
val onSecondaryContainerLight = Color(0xFF1E0796)
val primaryContainerLight = secondaryContainerLight
val onPrimaryContainerLight = onSecondaryContainerLight
val secondaryLight = getMissing(3)
val onSecondaryLight = getMissing(4)
val tertiaryLight = getMissing(5)
val onTertiaryLight = getMissing(6)
val tertiaryContainerLight = primaryContainerLight
val onTertiaryContainerLight = onPrimaryContainerLight
val errorLight = Color(0xFFD3202F)
val onErrorLight = Color(0xFFFFFFFF)
val errorContainerLight = Color(0xFFFEDBD9)
val onErrorContainerLight = Color(0xFF941C1E)
val backgroundLight = Color(0xFFF7F8FD)
val onBackgroundLight = Color(0xFF222222)
val surfaceLight = Color(0xFFF1F2F7)
val onSurfaceLight = Color(0xFF161619)
val surfaceVariantLight = surfaceLight
val onSurfaceVariantLight = Color(0xFF48484C)
val outlineLight = Color(0xFF747478)
val outlineVariantLight = Color(0xFFC9CACF)
val scrimLight = Color(0xFF000000)
val inverseSurfaceLight = Color(0xFF161619)
val inverseOnSurfaceLight = Color(0xFFF7F8FD)
val inversePrimaryLight = Color(0xFF958BE0)
val surfaceDimLight = Color(0xFFD6D7DC)
val surfaceBrightLight = Color(0xFFFFFFFF)
val surfaceContainerLowestLight = Color(0xFFFFFFFF)
val surfaceContainerLowLight = Color(0xFFFFFFFF)
val surfaceContainerLight = Color(0xFFF7F8FD)
val surfaceContainerHighLight = Color(0xFFFFFFFF)
val surfaceContainerHighestLight = Color(0xFFFFFFFF)


val primaryDark = Color(0xFF869DFF)
val onPrimaryDark = Color(0xFF100662)
val primaryContainerDark = getMissing(14)
val onPrimaryContainerDark = getMissing(15)
val secondaryDark = getMissing(16)
val onSecondaryDark = getMissing(17)
val secondaryContainerDark = Color(0xFF333337)
val onSecondaryContainerDark = Color(0xFF869DFF)
val tertiaryDark = getMissing(18)
val onTertiaryDark = getMissing(19)
val tertiaryContainerDark = getMissing(20)
val onTertiaryContainerDark = getMissing(21)
val errorDark = Color(0xFFFFA597)
val onErrorDark = Color(0xFF621512)
val errorContainerDark = Color(0xFF2E0704)
val onErrorContainerDark = Color(0xFFFFB8AD)
val backgroundDark = getMissing(22)
val onBackgroundDark = getMissing(23)
val surfaceDark = Color(0xFF161619)
val onSurfaceDark = Color(0xFFF1F2F7)
val surfaceVariantDark = getMissing(24)
val onSurfaceVariantDark = Color(0xFFC9CACF)
val outlineDark = Color(0xFF808084)
val outlineVariantDark = Color(0xFF48484C)
val scrimDark = getMissing(25)
val inverseSurfaceDark = Color(0xFFF7F8FD)
val inverseOnSurfaceDark = Color(0xFF161619)
val inversePrimaryDark = getMissing(26)
val surfaceDimDark = Color(0xFF000000)
val surfaceBrightDark = Color(0xFF333337)
val surfaceContainerLowestDark = Color(0xFF000000)
val surfaceContainerLowDark = Color(0xFF161619)
val surfaceContainerDark = Color(0xFF1E1E21)
val surfaceContainerHighDark = Color(0xFF242427)
val surfaceContainerHighestDark = Color(0xFF29292C)





