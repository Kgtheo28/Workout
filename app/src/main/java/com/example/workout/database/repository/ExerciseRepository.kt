package com.example.workout.database.repository

import androidx.lifecycle.LiveData
import com.example.workout.ExerciseInterface
import com.example.workout.database.data.Exercise
import com.example.workout.database.data.ExerciseDao

class ExerciseRepository(private val exerciseDao: ExerciseDao) {

    val readAllData: LiveData<List<Exercise>> = exerciseDao.readAllData()
    suspend fun addExercise(exercise: Exercise) {
        exerciseDao.addExercise(exercise)
    }


   suspend fun deleteAllExercise() {
        exerciseDao.deleteAllExercise()
    }

}