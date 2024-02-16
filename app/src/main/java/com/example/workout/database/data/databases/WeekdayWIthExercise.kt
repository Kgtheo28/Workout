package com.example.workout.database.data.databases

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.workout.database.data.Exercise
import com.example.workout.database.data.ExerciseWeekdayCrossRef
import com.example.workout.database.data.Weekday

data class WeekdayWIthExercise(
    @Embedded val weekday: Weekday,
    @Relation(
        parentColumn = "weekdayId",
        entityColumn = "id",
        associateBy = Junction(ExerciseWeekdayCrossRef::class)
    )
    val exercise: List<Exercise>
)
