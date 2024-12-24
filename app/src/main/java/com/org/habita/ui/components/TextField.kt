package com.org.habita.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.org.habita.ui.theme.baseBlack
import com.org.habita.ui.theme.pureWhite
import com.org.habita.ui.theme.semiBoldNun
import com.org.habita.ui.theme.strokeColor
import com.org.habita.ui.theme.textColor

@Composable
fun HabitaTextField(modifier: Modifier = Modifier, onTextChange: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            text = newText
            onTextChange(newText)
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = baseBlack,
            focusedTextColor = baseBlack,
            unfocusedBorderColor = strokeColor,
            focusedBorderColor = strokeColor,
            unfocusedContainerColor = pureWhite,
            focusedContainerColor = pureWhite
        ),
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(49.dp)
    )
}

@Composable
fun InputSection(
    modifier: Modifier = Modifier,
    sectionTitle: String,
    headerVisible: Boolean = true,
    paddingStart: Int = 40,
    paddingEnd: Int = 40,
    onValueChange: (String) -> Unit
) {
    Column(modifier = modifier.padding(start = paddingStart.dp, end = paddingEnd.dp)) {
        if (headerVisible) Text(
            text = sectionTitle,
            style = semiBoldNun,
            fontSize = 14.sp,
            color = textColor
        )
        Spacer(modifier = Modifier.height(8.dp))
        HabitaTextField(
            onTextChange = onValueChange
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun TextFieldPrev() {
    HabitaTextField() { }
}

@Preview(showSystemUi = true)
@Composable
fun SectionPrev(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    InputSection(modifier = modifier, sectionTitle = "Name", headerVisible = true) {
        text = it
    }
}