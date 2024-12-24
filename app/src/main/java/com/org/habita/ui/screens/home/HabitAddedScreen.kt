package com.org.habita.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.habita.R
import com.org.habita.ui.components.GradientButton
import com.org.habita.ui.theme.baseBlack
import com.org.habita.ui.theme.boldNun
import com.org.habita.ui.theme.semiBoldNun
import com.org.habita.ui.theme.textColor

@Composable
fun HabitAddedScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.calendar_illustration),
                contentDescription = null
            )
            Text("Done!", fontSize = 36.sp, style = boldNun, color = baseBlack)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "New Habit Goal has been added",
                fontSize = 16.sp,
                style = semiBoldNun,
                color = textColor
            )
            Text(
                "Let's do the best to achieve your goal!",
                fontSize = 16.sp,
                style = semiBoldNun,
                color = textColor
            )
            Spacer(modifier = Modifier.height(46.dp))
            GradientButton(
                btnText = "OK",
                modifier = Modifier.padding(start = 39.dp, end = 39.dp)
            ) { }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AddedScreen() {
    HabitAddedScreen()
}