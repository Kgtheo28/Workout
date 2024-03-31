package com.example.workout.database.data

import androidx.room.Entity
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "workout_table")
data class Exercise(
    val bodyPart: String,
    val exerciseName: String,
    val weekdayName: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
