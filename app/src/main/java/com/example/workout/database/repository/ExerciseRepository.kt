package com.example.workout.database.repository

import androidx.lifecycle.LiveData
import com.example.workout.database.data.Exercise
import com.example.workout.database.data.ExerciseDao

class ExerciseRepository(
    private val exerciseDao: ExerciseDao
) {

    val readAllData: LiveData<List<Exercise>> = exerciseDao.readAllData()

    // Filter Exercises by Weekday
    val readMondayData: LiveData<List<Exercise>> = exerciseDao.readMondayData()
    val readTuesdayData: LiveData<List<Exercise>> = exerciseDao.readTuesdayData()
    val readWednesdayData: LiveData<List<Exercise>> = exerciseDao.readWednesdayData()
    val readThursdayData: LiveData<List<Exercise>> = exerciseDao.readThursdayData()
    val readFridayData: LiveData<List<Exercise>> = exerciseDao.readFridayData()
    val readSaturdayData: LiveData<List<Exercise>> = exerciseDao.readSaturdayData()
    val readSundayData: LiveData<List<Exercise>> = exerciseDao.readSundayData()

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


    // cross reference relation




}