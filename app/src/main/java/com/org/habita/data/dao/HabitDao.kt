package com.org.habita.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.org.habita.data.entity.Habit
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit(habit: Habit)

    @Query("SELECT * FROM habits")
    fun getAllHabits(): Flow<List<Habit>>

    @Delete
    suspend fun deleteHabit(habit: Habit)
}