package com.org.habita.ui.screens.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
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
import com.org.habita.ui.components.HabitaWhiteButton
import com.org.habita.ui.components.InputSection
import com.org.habita.ui.theme.baseOrange
import com.org.habita.ui.theme.boldNun
import com.org.habita.ui.theme.extraBoldNun
import com.org.habita.ui.theme.regularNun
import com.org.habita.ui.theme.semiBoldNun
import com.org.habita.ui.theme.surfaceColor
import com.org.habita.ui.theme.textColorAdd

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onSignUpClicked: () -> Unit,
    onForgotPasswordClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(surfaceColor)
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(start = 40.dp, end = 40.dp, top = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Log In", fontSize = 44.sp, style = boldNun)
                Column(modifier = Modifier.align(Alignment.Bottom)) {
                    Row(modifier = Modifier.clickable { onSignUpClicked() }) {
                        Text(
                            "Sign Up",
                            style = extraBoldNun,
                            fontSize = 14.sp,
                            color = baseOrange
                        )
                        Icon(
                            painter = painterResource(R.drawable.arrow_back_ios),
                            contentDescription = "",
                            tint = baseOrange
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
            Spacer(modifier = Modifier.height(53.dp))
            InputSection(sectionTitle = "Email") { }
            Spacer(modifier = Modifier.height(22.dp))
            InputSection(sectionTitle = "Password") { }
            Spacer(modifier = Modifier.height(27.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp, end = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = true, onCheckedChange = {}, colors = CheckboxDefaults.colors(
                            checkedColor = baseOrange
                        )
                    )
                    Text(
                        text = "Remember me",
                        style = regularNun,
                        fontSize = 14.sp,
                        color = textColorAdd
                    )
                }
                Text(
                    "Forgot Password?",
                    style = semiBoldNun,
                    fontSize = 14.sp,
                    color = baseOrange,
                    modifier = Modifier.clickable { onForgotPasswordClicked() }
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            GradientButton(
                modifier = modifier.padding(start = 40.dp, end = 40.dp),
                btnText = "Log In"
            ) { }
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                "Or log in with: ",
                style = regularNun,
                fontSize = 14.sp,
                color = textColorAdd
            )
            Spacer(modifier = Modifier.height(10.dp))
            HabitaWhiteButton(
                modifier = modifier.padding(start = 40.dp, end = 40.dp),
                btnText = "Log In"
            ) { }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginPrev() {
    LoginScreen(onSignUpClicked = {}, onForgotPasswordClicked = {})
}