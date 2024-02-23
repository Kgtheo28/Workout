package com.example.workout.database.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface ExerciseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addExercise(exercise: Exercise)

    @Update
    suspend fun updateExercise(exercise: Exercise)

    @Delete
    suspend fun deleteExercise(exercise: Exercise)


    @Query("DELETE FROM workout_table")
    suspend fun deleteAllExercise()

    @Query("SELECT * FROM workout_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Exercise>>

}
