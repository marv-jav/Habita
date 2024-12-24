package com.org.habita.ui.navigation

sealed class HabitaNavigation(val route: String) {
    data object SignupScreen : HabitaNavigation("signup")
    data object LoginScreen : HabitaNavigation("login")
    data object ForgotPasswordScreen : HabitaNavigation("forgot_password")
    data object NewPasswordScreen : HabitaNavigation("new_password")
    data object OtpCodeScreen : HabitaNavigation("otp_code_screen")
    data object OverviewScreen : HabitaNavigation("overview_screen")
    data object ActivityScreen : HabitaNavigation("activity_screen")
    data object SettingsScreen : HabitaNavigation("settings_screen")
}