package com.org.habita.models

data class Habit(val title: String, val description: String, val completed: Boolean)

val habitList: List<Habit> = listOf(
    Habit("Meditating", "Meditation", completed = true),
    Habit("Read Philosophy", "Reading", completed = true),
    Habit("Journaling", "Journal", completed = false)
)
