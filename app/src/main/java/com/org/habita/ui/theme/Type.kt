package com.org.habita.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.org.habita.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
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

val boldNun = TextStyle(
    fontFamily = FontFamily(Font(R.font.nunito_bold))
)

val regularNun = TextStyle(
    fontFamily = FontFamily(Font(R.font.nunito_regular))
)

val mediumNun = TextStyle(
    fontFamily = FontFamily(Font(R.font.nunito_medium))
)

val lightNun = TextStyle(
    fontFamily = FontFamily(Font(R.font.nunito_light))
)

val semiBoldNun = TextStyle(
    fontFamily = FontFamily(Font(R.font.nunito_semi_bold))
)

val extraBoldNun = TextStyle(
    fontFamily = FontFamily(
        Font(R.font.nunito_extra_bold)
    )
)