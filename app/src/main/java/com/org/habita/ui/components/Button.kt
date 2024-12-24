package com.org.habita.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.org.habita.R
import com.org.habita.ui.theme.baseOrange
import com.org.habita.ui.theme.extraBoldNun
import com.org.habita.ui.theme.pureWhite

@Composable
fun GradientButton(modifier: Modifier = Modifier, btnText: String, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(pureWhite, baseOrange),
                    start = Offset(-100f, 100f),
                    end = Offset(100f, 100f)
                ),
                shape = RoundedCornerShape(4.dp)
            )
            .height(49.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = btnText,
            color = Color.White,
            style = extraBoldNun
        )
    }
}

@Composable
fun HabitaWhiteButton(modifier: Modifier = Modifier, btnText: String, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .background(
                color = pureWhite,
                shape = RoundedCornerShape(4.dp)
            )
            .height(49.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(painter = painterResource(R.drawable.google_icon), contentDescription = null)
    }
}

@Preview
@Composable
private fun ButtonPrev() {
    HabitaWhiteButton(btnText = "Sign Up", onClick = {})
}