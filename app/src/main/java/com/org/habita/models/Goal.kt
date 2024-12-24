package com.org.habita.models

data class Goal(val title: String, val frequency: String, val progress: Float)

val goalList: List<Goal> = listOf(
    Goal("Finish 5 Philosophy Books", "Everyday", progress = 0.3f),
    Goal("Finish Habita", "Everyday", progress = 0.6f),
    Goal("Pray for Love", "Everyday", progress = 0.8f)
)
