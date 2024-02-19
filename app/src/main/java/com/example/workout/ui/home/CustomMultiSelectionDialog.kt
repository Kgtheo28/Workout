package com.example.workout.ui.home

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
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
import java.io.ByteArrayOutputStream

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
            //addData3()

        }
    }

    private fun addData2() {
        val checkBoxWorkout1 = binding.checkbox1
        val workoutName1 = binding.workoutName1.text.toString()
        val equipment1 = binding.equipment1.text.toString()



        val checkBoxWorkout2 = binding.checkbox2
        val workoutName2 = binding.workoutName2.text.toString()
        val equipment2 = binding.equipment2.text.toString()

        val checkBoxWorkout3 = binding.checkbox3
        val workoutName3 = binding.workoutName3.text.toString()
        val equipment3 = binding.equipment3.text.toString()

        val checkBoxWorkout4 = binding.checkbox4
        val workoutName4 = binding.workoutName4.text.toString()
        val equipment4 = binding.equipment4.text.toString()

        val checkBoxWorkout5 = binding.checkbox5
        val workoutName5 = binding.workoutName5.text.toString()
        val equipment5 = binding.equipment5.text.toString()

        val checkBoxWorkout6 = binding.checkbox6
        val workoutName6 = binding.workoutName6.text.toString()
        val equipment6 = binding.equipment6.text.toString()

        val checkBoxWorkout7 = binding.checkbox7
        val workoutName7 = binding.workoutName7.text.toString()
        val equipment7 = binding.equipment7.text.toString()

        val checkBoxWorkout8 = binding.checkbox8
        val workoutName8 = binding.workoutName8.text.toString()
        val equipment8 = binding.equipment8.text.toString()


        val mondayCheckBox = binding.checkBoxMonday
        val tuesdayCheckBox = binding.checkBoxTuesday
        val wednesdayCheckBox = binding.checkBoxWednesday
        val thursdayCheckBox = binding.checkBoxThursday
        val fridayCheckBox = binding.checkBoxFriday
        val saturdayCheckBox = binding.checkBoxSarturday
        val sundayCheckBox = binding.checkBoxSunday

        fun addDataForWorkout(workoutName: String, equipment: String, workoutId: Int, weekdayId: Int) {
            val weekday = Weekday(mondayCheckBox.text.toString(), weekdayId)
            mUserViewModel.addWeekday(weekday)

            val exercise = Exercise(workoutName, equipment, workoutId)
            mUserViewModel.addExercise(exercise)

            val exerciseWeekdayCrossRef = ExerciseWeekdayCrossRef(workoutId, weekdayId, workoutName, equipment)
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
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, 1, 4)
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, 1, 5)
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, 1, 6)
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, 1, 7)
            }

            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else if (checkBoxWorkout2.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, 2, 1)
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, 2, 2)
            } else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, 3, 3)
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, 4, 4)
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, 5, 5)
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, 6, 6)
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, 7, 7)
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else if (checkBoxWorkout3.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName3, equipment3, 3, 1)
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName3, equipment3, 3, 2)
            } else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName3, equipment3, 3, 3)
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName3, equipment3, 3, 4)
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName3, equipment3, 3, 5)
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName3, equipment3, 3, 6)
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName3, equipment3, 3, 7)
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else if (checkBoxWorkout4.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName4, equipment4, 4, 1)
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName4, equipment4, 4, 2)
            } else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName4, equipment4, 4, 3)
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName4, equipment4, 4, 4)
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName4, equipment4, 4, 5)
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName4, equipment4, 4, 6)
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName4, equipment4, 4, 7)
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else if (checkBoxWorkout5.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName5, equipment5, 5, 1)
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName5, equipment5, 5, 2)
            } else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName5, equipment5, 5, 3)
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName5, equipment5, 5, 4)
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName5, equipment5, 5, 5)
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName5, equipment5, 5, 6)
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName5, equipment5, 5, 7)
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else if (checkBoxWorkout6.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName6, equipment6, 6, 1)
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName6, equipment6, 6, 2)
            } else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName6, equipment6, 6, 3)
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName6, equipment6, 6, 4)
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName6, equipment6, 6, 5)
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName6, equipment6, 6, 6)
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName6, equipment6, 6, 7)
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else if (checkBoxWorkout7.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName7, equipment7, 7, 1)
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName7, equipment7, 7, 2)
            } else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName7, equipment7, 7, 3)
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName7, equipment7, 7, 4)
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName7, equipment7, 7, 5)
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName7, equipment7, 7, 6)
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName7, equipment7, 7, 7)
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else if (checkBoxWorkout8.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName8, equipment8, 8, 1)
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName8, equipment8, 8, 2)
            } else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName8, equipment8, 8, 3)
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName8, equipment8, 8, 4)
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName8, equipment8, 8, 5)
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName8, equipment8, 8, 6)
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName8, equipment8, 8, 7)
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else {
            Toast.makeText(this, "You need to pick an Exercise", Toast.LENGTH_LONG).show()
        }
    }

    private fun addData3(){

        val checkBoxWorkout1 = binding.checkbox1
        val workoutName1 = binding.workoutName1.text.toString()
        val equipment1 = binding.equipment1.text.toString()

        val checkBoxWorkout2 = binding.checkbox2
        val workoutName2 = binding.workoutName2.text.toString()
        val equipment2 = binding.equipment2.text.toString()

        val checkBoxWorkout3 = binding.checkbox3
        val workoutName3 = binding.workoutName3.text.toString()
        val equipment3 = binding.equipment3.text.toString()

        val mondayCheckBox = binding.checkBoxMonday
        val tuesdayCheckBox = binding.checkBoxTuesday
        val wednesdayCheckBox = binding.checkBoxWednesday

        fun addDataForWorkout(workoutName: String, equipment: String, workoutId: Int, weekdayId: Int) {
            val weekday = Weekday(mondayCheckBox.text.toString(), weekdayId)
            mUserViewModel.addWeekday(weekday)

            val exercise = Exercise(workoutName, equipment, workoutId)
            mUserViewModel.addExercise(exercise)

            val exerciseWeekdayCrossRef = ExerciseWeekdayCrossRef(workoutId, weekdayId, workoutName, equipment)
            mUserViewModel.addCrossRef(exerciseWeekdayCrossRef)

            Toast.makeText(this, "Successfully added", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@CustomMultiSelectionDialog, MainActivity::class.java))
        }

        when(checkBoxWorkout1.isChecked){
              mondayCheckBox.isChecked -> addDataForWorkout(workoutName1, equipment1, 1, 1)
            tuesdayCheckBox.isChecked -> addDataForWorkout(workoutName1, equipment1, 1, 2)
            wednesdayCheckBox.isChecked -> addDataForWorkout(workoutName1, equipment1, 1, 3)
            else -> {
                Toast.makeText(this, "You need to pick an Exercise", Toast.LENGTH_LONG).show()
            }
        }

        when(checkBoxWorkout2.isChecked){
            mondayCheckBox.isChecked -> addDataForWorkout(workoutName2, equipment2, 2, 1)
            tuesdayCheckBox.isChecked -> addDataForWorkout(workoutName2, equipment2, 2, 2)
            wednesdayCheckBox.isChecked -> addDataForWorkout(workoutName2, equipment2, 2, 3)
            else -> {
                Toast.makeText(this, "You need to pick an Exercise", Toast.LENGTH_LONG).show()
            }
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


