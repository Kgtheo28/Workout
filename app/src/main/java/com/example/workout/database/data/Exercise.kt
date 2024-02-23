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

@Entity(tableName = "weekday_table")
data class Weekday(
    val weekdayName: String,
    @PrimaryKey(autoGenerate = true)
    val weekdayId : Int,

)

@Entity(tableName = "exercise_weekday_cross", primaryKeys = ["id", "weekdayId"])
data class ExerciseWeekdayCrossRef(
    val id: Int,
    val weekdayId: Int,
    val exerciseName: String,
    val equipment: String
)