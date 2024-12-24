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
import androidx.compose.foundation.lazy.LazyColumn
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
import com.org.habita.ui.theme.surfaceColor
import com.org.habita.ui.theme.textColorAdd

@Composable
fun SignupScreen(
    modifier: Modifier = Modifier,
    onLogInClicked: () -> Unit,
    onSignUpClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(surfaceColor)
    ) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                item {
                    Row(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                            .padding(start = 40.dp, end = 40.dp, top = 40.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Sign Up", fontSize = 44.sp, style = boldNun)
                        Column(modifier = Modifier.align(Alignment.Bottom)) {
                            Row(modifier = Modifier.clickable { onLogInClicked() }) {
                                Text(
                                    "Log In",
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
                    InputSection(sectionTitle = "Name") { }
                    Spacer(modifier = Modifier.height(22.dp))
                    InputSection(sectionTitle = "Email") { }
                    Spacer(modifier = Modifier.height(22.dp))
                    InputSection(sectionTitle = "Password") { }
                    Spacer(modifier = Modifier.height(22.dp))
                    InputSection(sectionTitle = "Password Confirmation") { }
                    Spacer(modifier = Modifier.height(48.dp))
                    GradientButton(
                        modifier = modifier.padding(start = 40.dp, end = 40.dp),
                        btnText = "Sign Up"
                    ) {
                        onSignUpClicked()
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        "Or sign up with: ",
                        style = regularNun,
                        fontSize = 14.sp,
                        color = textColorAdd
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    HabitaWhiteButton(
                        modifier = modifier.padding(start = 40.dp, end = 40.dp),
                        btnText = "Sign Up"
                    ) {
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SignupPrev() {
    SignupScreen(onLogInClicked = {}, onSignUpClicked = {})
}