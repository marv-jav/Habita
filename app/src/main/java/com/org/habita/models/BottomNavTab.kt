package com.org.habita.models

import com.org.habita.R

data class BottomNavTab(
    val title: String,
    val route: String,
    val selectedIcon: Int,
    val unselectedIcon: Int
)

val items = listOf(
    BottomNavTab(
        title = "Home",
        route = "overview_screen",
        selectedIcon = R.drawable.home,
        unselectedIcon = R.drawable.home_default
    ),
    BottomNavTab(
        title = "Activity",
        route = "activity_screen",
        selectedIcon = R.drawable.activity_selected,
        unselectedIcon = R.drawable.activity_default
    ),
    BottomNavTab(
        title = "Settings",
        route = "settings_screen",
        selectedIcon = R.drawable.settings_selected,
        unselectedIcon = R.drawable.settings_default
    )
)