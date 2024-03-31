package com.example.workout.database.repository

import androidx.lifecycle.LiveData
import com.example.workout.database.data.Exercise
import com.example.workout.database.data.ExerciseDao
import javax.inject.Inject

class ExerciseRepository (private var exerciseDao: ExerciseDao) {

    val readAllData: LiveData<List<Exercise>> = exerciseDao.readAllData()

    suspend fun addExercise(exercise: Exercise) {
        exerciseDao.addExercise(exercise)
    }

    suspend fun updateExercise(exercise: Exercise) {
        exerciseDao.updateExercise(exercise)
    }

    suspend fun deleteExercise(exercise: Exercise) {
        exerciseDao.deleteAllExercise()
    }

    suspend fun deleteAllExercise() {
        exerciseDao.deleteAllExercise()
    }

    fun readAllData(): LiveData<List<Exercise>> {
        return exerciseDao.readAllData()
    }

}