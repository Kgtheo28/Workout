package com.example.workout.database.repository

import androidx.lifecycle.LiveData
import com.example.workout.database.data.Exercise
import com.example.workout.database.data.ExerciseDao
import com.example.workout.database.data.ExerciseWeekdayCrossRef
import com.example.workout.database.data.ExerciseWeekdayCrossRefDao
import com.example.workout.database.data.Weekday
import com.example.workout.database.data.WeekdayDao
import com.example.workout.database.data.databases.ExerciseWithWeekday
import com.example.workout.database.data.databases.WeekdayWIthExercise

class ExerciseRepository(
    private val exerciseDao: ExerciseDao,
    private val weekdayDao: WeekdayDao,
    private val exerciseWeekdayCrossRefDao: ExerciseWeekdayCrossRefDao
) {

    val readAllData: LiveData<List<Exercise>> = exerciseDao.readAllData()
    val readWeekdayWithExercise: LiveData<List<WeekdayWIthExercise>> = weekdayDao.readWeekdayWithExercise()
    val readWeekdayWithExercise2: LiveData<List<WeekdayWIthExercise>> = weekdayDao.readWeekdayWithExercise2()
    val readWeekdayWithExercise3: LiveData<List<WeekdayWIthExercise>> = weekdayDao.readWeekdayWithExercise3()

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

    suspend fun addWeekday(weekday: Weekday){
        weekdayDao.addWeekday(weekday)
    }

    suspend fun addCrossRef(exerciseWeekdayCrossRef: ExerciseWeekdayCrossRef){
        exerciseWeekdayCrossRefDao.addCrossRef(exerciseWeekdayCrossRef)
    }

    // cross reference relation




}