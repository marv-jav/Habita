package com.org.habita.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.org.habita.data.entity.Habit
import com.org.habita.repository.HabitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class HabitViewModel(private val habitRepository: HabitRepository) : ViewModel() {
    val allHabits: Flow<List<Habit>> = habitRepository.allHabits

    fun insertHabit(habit: Habit) {
        viewModelScope.launch {
            habitRepository.insertHabit(habit)
        }
    }

    fun deleteHabit(habit: Habit) {
        viewModelScope.launch {
            habitRepository.deleteHabit(habit)
        }
    }
}

class HabitViewModelFactory(private val repository: HabitRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HabitViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HabitViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}