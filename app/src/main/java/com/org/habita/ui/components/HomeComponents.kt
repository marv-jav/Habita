package com.org.habita.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.org.habita.R
import com.org.habita.models.Goal
import com.org.habita.models.Habit
import com.org.habita.models.habitList
import com.org.habita.models.items
import com.org.habita.ui.theme.baseBlack
import com.org.habita.ui.theme.baseGreen
import com.org.habita.ui.theme.baseOrange
import com.org.habita.ui.theme.boldNun
import com.org.habita.ui.theme.habitCardGreen
import com.org.habita.ui.theme.mediumNun
import com.org.habita.ui.theme.progressColor
import com.org.habita.ui.theme.progressTrackColor
import com.org.habita.ui.theme.pureWhite
import com.org.habita.ui.theme.semiBoldNun
import com.org.habita.utils.SectionType

@Composable
fun HabitCard(modifier: Modifier = Modifier, habit: Habit) {
    Box(
        modifier = modifier
            .height(58.dp)
            .fillMaxWidth()
            .background(
                color = if (habit.completed) habitCardGreen else pureWhite,
                shape = RoundedCornerShape(5.dp)
            ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 13.33.dp, end = 13.33.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                habit.title,
                style = semiBoldNun,
                fontSize = 16.sp,
                color = if (habit.completed) baseGreen else baseBlack
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                HabitaCheckBox(
                    checked = habit.completed,
                    onCheckedChange = {},
                    modifier = Modifier,
                )
                Icon(painter = painterResource(R.drawable.more_vertical), contentDescription = null)
            }
        }
    }
}

@Composable
fun HabitaCheckBox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    gradientColors: List<Color> = listOf(baseGreen, pureWhite),
    uncheckedColor: Color = Color.White,
    checkmarkColor: Color = Color.White,
    checkedStrokeColor: Color = habitCardGreen,
    uncheckedStrokeColor: Color = baseBlack,
) {
    val backgroundBrush = if (checked) {
        Brush.linearGradient(
            colors = gradientColors, start = Offset(0f, 0f), end = Offset(100f, 100f)
        )
    } else {
        SolidColor(uncheckedColor)
    }

    val strokeColor = if (checked) checkedStrokeColor else uncheckedStrokeColor

    Box(
        modifier = modifier
            .size(24.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundBrush)
            .border(width = 2.dp, color = strokeColor, RoundedCornerShape(8.dp))
            .clickable { onCheckedChange(!checked) }, contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Checked",
                tint = checkmarkColor,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun HabitaLinearProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    gradientColors: List<Color> = listOf(Color.Red, Color.Yellow, Color.Green),
    trackColor: Color = Color.LightGray,
    cornerRadius: Dp = 4.dp
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .background(trackColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .clip(RoundedCornerShape(cornerRadius))
                .background(Brush.linearGradient(gradientColors))
                .scale(scaleX = progress, scaleY = 1f) // Scale to represent progress
        )
    }
}

@Composable
fun GoalsItem(modifier: Modifier = Modifier, goal: Goal) {
    Box(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 11.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    goal.title,
                    style = boldNun,
                    fontSize = 16.sp,
                    color = baseBlack
                )
                Icon(painter = painterResource(R.drawable.more_vertical), contentDescription = null)
            }
            Spacer(modifier = Modifier.height(7.dp))
            Column(modifier = Modifier.width(290.dp)) {
                Card(shape = RoundedCornerShape(3.dp)) {
                    LinearProgressIndicator(
                        progress = { goal.progress },
                        modifier = Modifier
                            .height(13.dp)
                            .fillMaxWidth(),
                        color = baseOrange,
                    )
                }
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    "5 from 7 days target", style = mediumNun, fontSize = 14.sp, color = baseBlack
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    goal.frequency, style = mediumNun, fontSize = 14.sp, color = baseOrange
                )
            }
        }
    }
}

@Composable
fun TaskProgressIndicator(
    completedTasks: Int,
    totalTasks: Int,
    modifier: Modifier = Modifier,
    trackColor: Color = progressTrackColor,
    indicatorColor: Color = progressColor,
    strokeWidth: Dp = 14.dp
) {
    val progress = completedTasks.toFloat() / totalTasks.toFloat()

    // Display the circular progress indicator
    Box(
        contentAlignment = Alignment.Center, modifier = modifier.size(117.dp)
    ) {
        CircularProgressIndicator(
            progress = {
                1f  // Full circle for the track
            },
            modifier = Modifier.fillMaxSize(),
            color = trackColor,
            strokeWidth = strokeWidth,
        )

        // Indicator (progress circle)
        CircularProgressIndicator(
            progress = {
                progress  // Progress based on completed tasks
            },
            modifier = Modifier.fillMaxSize(),
            color = indicatorColor,
            strokeWidth = strokeWidth,
            strokeCap = StrokeCap.Butt
        )

        // Text to display the progress percentage (optional)
        Text(
            text = "${(progress * 100).toInt()}%",
            color = Color.White,
            style = boldNun,
            fontSize = 21.sp,
        )
    }
}

@Composable
fun HomeSections(
    modifier: Modifier = Modifier,
    sectionTitle: String = "Today Habit",
    sectionType: SectionType,
    habits: List<Habit> = listOf(),
    goals: List<Goal> = listOf(),
    seeAllClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(297.dp), colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(
                    start = 14.dp, end = 14.dp, top = 22.dp, bottom = 22.dp
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(sectionTitle, style = boldNun, fontSize = 21.sp, color = baseBlack)
                Text(
                    "See all",
                    style = boldNun,
                    fontSize = 14.sp,
                    color = baseOrange,
                    modifier = Modifier.clickable {
                        seeAllClick()
                    })
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(if (sectionType == SectionType.HABITS) habits else goals) {
                    if (sectionType == SectionType.HABITS) {
                        HabitCard(habit = it as Habit)
                    } else {
                        GoalsItem(goal = it as Goal)
                    }
                    Spacer(modifier = Modifier.height(17.dp))
                }
            }
        }
    }
}

@Composable
fun HabitaFAB(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(100.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        modifier = modifier.clickable { onClick() },
    ) {
        Image(
            painter = painterResource(R.drawable.fab_back),
            contentDescription = null,
            modifier = Modifier.padding(6.dp)
        )
    }
}

@Composable
fun HabitaBottomNav(navController: NavHostController, modifier: Modifier = Modifier) {
    var selectedItem by remember { mutableIntStateOf(0) }

    NavigationBar(containerColor = pureWhite, modifier = modifier) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (selectedItem == index) item.selectedIcon else item.unselectedIcon
                        ),
                        contentDescription = item.title
                    )
                },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = baseOrange,
                    unselectedIconColor = baseBlack,
                    indicatorColor = Color.White
                )
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun TaskPrev() {
    HomeSections(sectionTitle = "Habits", sectionType = SectionType.HABITS, habits = habitList) {}
}
