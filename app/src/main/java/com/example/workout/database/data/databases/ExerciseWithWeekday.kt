package com.example.workout.database.data.databases

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.workout.database.data.Exercise
import com.example.workout.database.data.ExerciseWeekdayCrossRef
import com.example.workout.database.data.Weekday

data class ExerciseWithWeekday(
    @Embedded val exercise: Exercise,
    @Relation(
        parentColumn = "id",
        entityColumn = "weekdayId",
        associateBy = Junction(ExerciseWeekdayCrossRef::class)
    )
    val weekday: List<Weekday>

)