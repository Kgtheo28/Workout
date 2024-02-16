package com.example.workout.ui.home

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import com.example.workout.MainActivity
import com.example.workout.R
import com.example.workout.database.ExerciseViewModel
import com.example.workout.database.data.Exercise
import com.example.workout.database.data.ExerciseWeekdayCrossRef
import com.example.workout.database.data.Weekday
import com.example.workout.databinding.ActivityCustomMultiSelectionDialogBinding
import com.example.workout.databinding.ActivityMainBinding
import com.example.workout.ui.dashboard.DashboardFragment

open class CustomMultiSelectionDialog: AppCompatActivity() {

    private lateinit var binding: ActivityCustomMultiSelectionDialogBinding

    private lateinit var mUserViewModel: ExerciseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityCustomMultiSelectionDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mUserViewModel = ViewModelProvider(this).get(ExerciseViewModel::class.java)


        val addBtn = binding.addBtn



        addBtn.setOnClickListener {
            //addData()
            addData2()

        }

    }

    private fun addData2() {
        val checkBoxWorkout1 = binding.checkbox1
        val workoutName1 = binding.workoutName1.text.toString()
        val equipment1 = binding.equipment1.text.toString()

        val checkBoxWorkout2 = binding.checkbox2
        val workoutName2 = binding.workoutName2.text.toString()
        val equipment2 = binding.equipment2.text.toString()

        val mondayCheckBox = binding.checkBoxMonday
        val tuesdayCheckBox = binding.checkBoxTuesday
        val wednesdayCheckBox = binding.checkBoxWednesday

        fun addDataForWorkout(workoutName: String, equipment: String, workoutId: Int, weekdayId: Int) {
            val weekday = Weekday(mondayCheckBox.text.toString(), weekdayId)
            mUserViewModel.addWeekday(weekday)

            val exercise = Exercise(workoutName, equipment, workoutId)
            mUserViewModel.addExercise(exercise)

            val exerciseWeekdayCrossRef = ExerciseWeekdayCrossRef(workoutId, weekdayId)
            mUserViewModel.addCrossRef(exerciseWeekdayCrossRef)

            Toast.makeText(this, "Successfully added", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@CustomMultiSelectionDialog, MainActivity::class.java))
        }

        if (checkBoxWorkout1.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, 1, 1)
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, 1, 2)
            }else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, 1, 3)
            }

            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        } else if (checkBoxWorkout2.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, 2, 1)
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, 2, 2)
            } else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, 1, 3)
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "You need to pick an Exercise", Toast.LENGTH_LONG).show()
        }
    }

    /*

    private fun addData() {
        // First workout properties
        val checkBoxWorkout1 = binding.checkbox1
        val workoutName = binding.workoutName1.text.toString()
        val equipment = binding.equipment1.text.toString()

        // Second Workout Properties
        val checkBoxWorkout2 = binding.checkbox2
        val workoutName2 = binding.workoutName2.text.toString()
        val equipment2 = binding.equipment2.text.toString()

        // Weekday Check Boxes
        val mondayCheckBox = binding.checkBoxMonday
        val tuesdayCheckBox = binding.checkBoxTuesday

        // If First Workout is Selected
        if(checkBoxWorkout1.isChecked){

            if(mondayCheckBox.isChecked){

                //adding Weekday to database
                val weekday = Weekday(mondayCheckBox.text.toString(), 1)

                mUserViewModel.addWeekday(weekday)

                // Adding Exercise to database
                val exercise = Exercise(workoutName, equipment, 1)

                mUserViewModel.addExercise(exercise)

                // Adding Cross reference to the two columns
                val exerciseWeekdayCrossRef = ExerciseWeekdayCrossRef(1,1)
                mUserViewModel.addCrossRef(exerciseWeekdayCrossRef)

                // Moving to the Main Activity after the process is done
                Toast.makeText(this, "Successfully added in Monday", Toast.LENGTH_LONG).show()
                startActivity(Intent(this@CustomMultiSelectionDialog, MainActivity::class.java))

            }

            else if(tuesdayCheckBox.isChecked){
                //adding Weekday to database
                val weekday = Weekday(tuesdayCheckBox.text.toString(), 2)

                mUserViewModel.addWeekday(weekday)

                // Adding Exercise to database
                val exercise = Exercise(workoutName, equipment, 1)

                mUserViewModel.addExercise(exercise)

                // Adding Cross reference to the two columns
                val exerciseWeekdayCrossRef = ExerciseWeekdayCrossRef(1,2)
                mUserViewModel.addCrossRef(exerciseWeekdayCrossRef)

                // Moving to the Main Activity after the process is done
                Toast.makeText(this, "Successfully  in Tuesday", Toast.LENGTH_LONG).show()
                startActivity(Intent(this@CustomMultiSelectionDialog, MainActivity::class.java))
            }

            else {
                Toast.makeText(this, "you need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }
        // Second Workout
        else if(checkBoxWorkout2.isChecked){

            if(mondayCheckBox.isChecked){

                //adding Weekday to database
                val weekday = Weekday(mondayCheckBox.text.toString(), 1)

                mUserViewModel.addWeekday(weekday)

                // Adding Exercise to database
                val exercise = Exercise(workoutName2, equipment2, 2)

                mUserViewModel.addExercise(exercise)

                // Adding Cross reference to the two columns
                val exerciseWeekdayCrossRef = ExerciseWeekdayCrossRef(2,1)
                mUserViewModel.addCrossRef(exerciseWeekdayCrossRef)

                // Moving to the Main Activity after the process is done
                Toast.makeText(this, "Successfully added in Monday", Toast.LENGTH_LONG).show()
                startActivity(Intent(this@CustomMultiSelectionDialog, MainActivity::class.java))

            }

            else if(tuesdayCheckBox.isChecked){
                //adding Weekday to database
                val weekday = Weekday(tuesdayCheckBox.text.toString(), 2)

                mUserViewModel.addWeekday(weekday)

                // Adding Exercise to database
                val exercise = Exercise(workoutName2, equipment2, 2)

                mUserViewModel.addExercise(exercise)

                // Adding Cross reference to the two columns
                val exerciseWeekdayCrossRef = ExerciseWeekdayCrossRef(2,2)
                mUserViewModel.addCrossRef(exerciseWeekdayCrossRef)

                // Moving to the Main Activity after the process is done
                Toast.makeText(this, "Successfully  in Tuesday", Toast.LENGTH_LONG).show()
                startActivity(Intent(this@CustomMultiSelectionDialog, MainActivity::class.java))
            }

            else {
                Toast.makeText(this, "you need to pick a weekday", Toast.LENGTH_LONG).show()
            }


        }else{
            Toast.makeText(this, "you need to pick an Exercise", Toast.LENGTH_LONG).show()
        }

    }

     */
}

