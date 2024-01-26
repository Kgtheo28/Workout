package com.example.workout.database.repository

import androidx.lifecycle.LiveData
import com.example.workout.database.data.Exercise
import com.example.workout.database.data.ExerciseDao

class ExerciseRepository(private val exerciseDao: ExerciseDao) {

    val readAllData: LiveData<List<Exercise>> = exerciseDao.readAllData()


    suspend fun addExercise(exercise: Exercise){
        exerciseDao.addExercise(exercise)
    }

    suspend fun updateExercise(exercise: Exercise){
        exerciseDao.updateExercise(exercise)
    }

    suspend fun deleteExercise(exercise: Exercise){
        exerciseDao.deleteExercise(exercise)
    }

    suspend fun deleteAllExercise(){
        exerciseDao.deleteAllExercise()
    }
}