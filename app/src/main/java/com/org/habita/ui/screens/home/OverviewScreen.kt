package com.org.habita.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.org.habita.R
import com.org.habita.models.goalList
import com.org.habita.models.habitList
import com.org.habita.ui.components.HabitaDialog
import com.org.habita.ui.components.HabitaFAB
import com.org.habita.ui.components.HomeSections
import com.org.habita.ui.components.TaskProgressIndicator
import com.org.habita.ui.theme.baseBlack
import com.org.habita.ui.theme.baseOrange
import com.org.habita.ui.theme.boldNun
import com.org.habita.ui.theme.pureWhite
import com.org.habita.ui.theme.semiBoldNun
import com.org.habita.ui.theme.surfaceColor
import com.org.habita.utils.SectionType
import com.org.habita.viewmodel.HabitViewModel

@Composable
fun OverviewScreen(modifier: Modifier = Modifier, viewModel: HabitViewModel) {
    var showDialog by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(surfaceColor)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(pureWhite)
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .padding(start = 18.dp, end = 16.dp)
                        .fillMaxWidth() // Adjusted to avoid infinite constraints
                ) {
                    Text("Sun, 1 March 2022", style = boldNun, fontSize = 16.sp, color = baseBlack)
                    Spacer(modifier = Modifier.height(5.dp))
                    Row {
                        Text("Hello, ", style = boldNun, fontSize = 28.sp, color = baseBlack)
                        Text("Sussy!", style = boldNun, fontSize = 28.sp, color = baseOrange)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.overview_background),
                            contentDescription = null,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Row(
                            modifier = Modifier
                                .padding(start = 25.dp)
                                .align(Alignment.CenterStart),
                            horizontalArrangement = Arrangement.spacedBy(25.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TaskProgressIndicator(3, 6)
                            Text(
                                "3 of 6 habits\ncompleted today",
                                style = semiBoldNun,
                                fontSize = 20.sp,
                                color = Color.White
                            )
                        }
                        Image(
                            painter = painterResource(R.drawable.cup_image),
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(end = 15.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                HomeSections(
                    sectionTitle = "Today Habit",
                    sectionType = SectionType.HABITS,
                    habits = habitList,
                    modifier = Modifier.padding(start = 18.dp, end = 18.dp)
                ) { }
                Spacer(modifier = Modifier.height(30.dp))
                HomeSections(
                    sectionTitle = "Your Goals",
                    sectionType = SectionType.GOALS,
                    goals = goalList,
                    modifier = Modifier.padding(start = 18.dp, end = 18.dp)
                ) { }
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
        HabitaFAB(
            modifier = modifier
                .align(Alignment.BottomEnd)
                .padding(end = 17.dp, bottom = 40.dp)
        ) {
            showDialog = true
        }
        if (showDialog) {
            HabitaDialog(
                modifier = modifier.align(Alignment.Center),
                onDismiss = { showDialog = false }, viewModel = viewModel
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun OverViewPrev() {

}