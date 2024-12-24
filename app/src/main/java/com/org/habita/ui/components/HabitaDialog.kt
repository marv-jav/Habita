package com.org.habita.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.org.habita.R
import com.org.habita.data.entity.Habit
import com.org.habita.ui.theme.baseBlack
import com.org.habita.ui.theme.boldNun
import com.org.habita.ui.theme.habitaGrey
import com.org.habita.ui.theme.regularNun
import com.org.habita.ui.theme.semiBoldNun
import com.org.habita.viewmodel.HabitViewModel

@Composable
fun HabitaDialog(modifier: Modifier = Modifier, onDismiss: () -> Unit, viewModel: HabitViewModel) {
    var alignment by remember { mutableStateOf(Alignment.CenterStart) }
    val dropDownModifier: Modifier = Modifier

    //Habit properties
    var habitName by remember { mutableStateOf("") }
    var habitDescription by remember { mutableStateOf("") }
    var habitFrequency by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(6.dp),
            modifier = modifier
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Create New Habit Goal",
                        style = boldNun,
                        fontSize = 18.sp,
                        color = baseBlack
                    )
                    Icon(
                        painter = painterResource(R.drawable.close_fill),
                        contentDescription = null,
                        modifier = Modifier.clickable { onDismiss() }
                    )
                }
                Spacer(modifier = Modifier.height(22.dp))
                InputSection(
                    sectionTitle = "Your Goal",
                    headerVisible = true,
                    paddingStart = 0,
                    paddingEnd = 0
                ) {
                    habitName = it
                }
                Spacer(modifier = Modifier.height(22.dp))
                InputSection(
                    sectionTitle = "Habit Name", headerVisible = true, paddingStart = 0,
                    paddingEnd = 0
                ) {
                    habitDescription = it
                }
                Spacer(modifier = Modifier.height(22.dp))
                Box(
                    modifier = dropDownModifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(
                        "Period",
                        fontSize = 14.sp,
                        style = semiBoldNun,
                        color = baseBlack,
                        modifier = dropDownModifier.align(alignment)
                    )
                    CustomDropdown(
                        options = listOf("Everyday", "Everyday", "Everyday"),
                        modifier = Modifier.align(Alignment.CenterEnd)
                    ) {
                        habitFrequency = it
                    }
                }
                Spacer(modifier = Modifier.height(22.dp))
                Box(
                    modifier = dropDownModifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                ) {
                    Text(
                        "Habit Type", fontSize = 14.sp, style = semiBoldNun, color = baseBlack,
                        modifier = dropDownModifier.align(alignment)
                    )
                    CustomDropdown(
                        options = listOf("Everyday", "Everyday", "Everyday"),
                        modifier = Modifier.align(Alignment.CenterEnd),
                        isExpanded = {
                            alignment = if (it) {
                                Alignment.TopEnd
                            } else {
                                Alignment.CenterStart
                            }
                        }
                    ) {
                        habitFrequency = it
                    }
                }
                Spacer(modifier = Modifier.height(22.dp))
                GradientButton(btnText = "Create New") {
                    viewModel.insertHabit(
                        Habit(
                            name = habitName,
                            description = habitDescription,
                            frequency = habitFrequency
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun CustomDropdown(
    modifier: Modifier,
    options: List<String>,
    isExpanded: (Boolean) -> Unit = {},
    onOptionSelected: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options.firstOrNull() ?: "") }

    Box(modifier = modifier) {
        Card(
            modifier = Modifier
                .width(180.dp)
                .height(34.dp),
            shape = RoundedCornerShape(4.dp),
            colors = CardDefaults.cardColors(
                containerColor = habitaGrey,
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    selectedOption,
                    style = boldNun,
                    fontSize = 14.sp,
                    color = baseBlack,
                    modifier = Modifier.padding(start = 11.dp)
                )
                Icon(
                    painter = painterResource(if (expanded) R.drawable.chevron_down else R.drawable.chevron_right),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 11.dp)
                        .clickable {
                            expanded = !expanded
                        }
                )
            }
        }
        AnimatedVisibility(visible = expanded) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .border(1.dp, Color.Gray)
            ) {
                options.forEach { option ->
                    Text(text = option, modifier = Modifier
                        .clickable {
                            selectedOption = option
                            expanded = false
                            onOptionSelected(option)
                            isExpanded(false)
                        }
                        .padding(8.dp), color = baseBlack, fontSize = 14.sp, style = regularNun)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DialogPrev() {

}

@Preview()
@Composable
private fun DropPrev() {

}