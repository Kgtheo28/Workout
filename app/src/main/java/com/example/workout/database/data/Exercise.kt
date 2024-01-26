package com.example.workout.database.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout_table")
data class Exercise(
    val bodyPart: String,
    val exerciseName: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
