package com.org.habita.ui.screens.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.habita.ui.components.GradientButton
import com.org.habita.ui.components.InputSection
import com.org.habita.ui.theme.semiBoldNun
import com.org.habita.ui.theme.surfaceColor
import com.org.habita.ui.theme.textColor

@Composable
fun NewPasswordScreen(modifier: Modifier = Modifier, onResetPasswordClicked: () -> Unit) {
    Column(modifier = modifier.background(surfaceColor)) {
        Text(
            "Enter the OTP code we've sent to your email",
            fontSize = 14.sp,
            style = semiBoldNun,
            modifier = Modifier.padding(top = 70.dp, start = 40.dp, end = 40.dp),
            color = textColor
        )
        Spacer(modifier = Modifier.height(27.dp))
        InputSection(sectionTitle = "", headerVisible = false) {

        }
        Spacer(modifier = Modifier.height(27.dp))
        GradientButton(
            modifier = Modifier.padding(start = 40.dp, end = 40.dp),
            btnText = "Submit"
        ) {
            onResetPasswordClicked()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun NewPassScreen() {
    NewPasswordScreen { }
}