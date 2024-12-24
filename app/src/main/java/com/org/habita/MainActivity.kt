package com.org.habita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.org.habita.data.database.HabitDatabase
import com.org.habita.repository.HabitRepository
import com.org.habita.ui.components.HabitaBottomNav
import com.org.habita.ui.navigation.HabitaNavigation
import com.org.habita.ui.screens.authentication.ForgotPasswordScreen
import com.org.habita.ui.screens.authentication.LoginScreen
import com.org.habita.ui.screens.authentication.SignupScreen
import com.org.habita.ui.screens.home.ActivityScreen
import com.org.habita.ui.screens.home.OverviewScreen
import com.org.habita.ui.screens.home.SettingsScreen
import com.org.habita.viewmodel.HabitViewModel
import com.org.habita.viewmodel.HabitViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = HabitDatabase.getDatabase(context = this)
        val repository = HabitRepository(database.habitDao())
        val viewModelFactory = HabitViewModelFactory(repository)

        enableEdgeToEdge()
        setContent {
            val viewModel: HabitViewModel = viewModel(factory = viewModelFactory)
            HabitaApp(viewModel = viewModel)
        }
    }
}

@Composable
fun HabitaApp(modifier: Modifier = Modifier, viewModel: HabitViewModel) {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (currentRoute != HabitaNavigation.SignupScreen.route &&
                currentRoute != HabitaNavigation.LoginScreen.route &&
                currentRoute != HabitaNavigation.ForgotPasswordScreen.route
            ) {
                HabitaBottomNav(navController)
            }
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HabitaNavigation.SignupScreen.route,
            modifier = modifier.padding(innerPadding),
        ) {
            composable(HabitaNavigation.SignupScreen.route) {
                SignupScreen(
                    onLogInClicked = { navController.navigate(HabitaNavigation.LoginScreen.route) },
                    onSignUpClicked = { navController.navigate(HabitaNavigation.OverviewScreen.route) })
            }
            composable(HabitaNavigation.LoginScreen.route) {
                LoginScreen(
                    onSignUpClicked = { navController.navigate(HabitaNavigation.SignupScreen.route) },
                    onForgotPasswordClicked = { navController.navigate(HabitaNavigation.ForgotPasswordScreen.route) })
            }
            composable(HabitaNavigation.ForgotPasswordScreen.route) {
                ForgotPasswordScreen { }
            }
            composable(HabitaNavigation.OverviewScreen.route) {
                OverviewScreen(viewModel = viewModel)
            }
            composable(HabitaNavigation.ActivityScreen.route) {
                ActivityScreen()
            }
            composable(HabitaNavigation.SettingsScreen.route) {
                SettingsScreen()
            }
        }
    }
}