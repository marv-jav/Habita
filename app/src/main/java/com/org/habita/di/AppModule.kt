package com.org.habita.di

import com.org.habita.data.database.HabitDatabase
import com.org.habita.repository.HabitRepository
import com.org.habita.viewmodel.HabitViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    //Database Instance
    single { HabitDatabase.getDatabase(get()).habitDao() }

    //Repository Instance
    single { HabitRepository(get()) }

    //ViewModel Instance
    viewModel { HabitViewModel(get()) }
}