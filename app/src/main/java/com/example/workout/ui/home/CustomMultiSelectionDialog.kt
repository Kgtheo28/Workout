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
            addData()

        }
    }

    private fun addData() {
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

        fun addDataForWorkout(workoutName: String, equipment: String, weekdayName: String) {

            val exercise = Exercise(workoutName, equipment, weekdayName)
            mUserViewModel.addExercise(exercise)

            Toast.makeText(this, "Successfully added", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@CustomMultiSelectionDialog, MainActivity::class.java))
        }

        if (checkBoxWorkout1.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, mondayCheckBox.text.toString())
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, tuesdayCheckBox.text.toString())
            }else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, wednesdayCheckBox.text.toString())
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, thursdayCheckBox.text.toString())
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, fridayCheckBox.text.toString())
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, saturdayCheckBox.text.toString())
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName1, equipment1, sundayCheckBox.text.toString())
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }
        else if (checkBoxWorkout2.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, mondayCheckBox.text.toString())
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, tuesdayCheckBox.text.toString())
            }else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, wednesdayCheckBox.text.toString())
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, thursdayCheckBox.text.toString())
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, fridayCheckBox.text.toString())
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, saturdayCheckBox.text.toString())
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName2, equipment2, sundayCheckBox.text.toString())
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else if (checkBoxWorkout3.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName3, equipment3, mondayCheckBox.text.toString())
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName3, equipment3, tuesdayCheckBox.text.toString())
            }else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName3, equipment3, wednesdayCheckBox.text.toString())
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName3, equipment3, thursdayCheckBox.text.toString())
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName3, equipment3, fridayCheckBox.text.toString())
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName3, equipment3, saturdayCheckBox.text.toString())
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName3, equipment3, sundayCheckBox.text.toString())
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else if (checkBoxWorkout4.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName4, equipment4, mondayCheckBox.text.toString())
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName4, equipment4, tuesdayCheckBox.text.toString())
            }else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName4, equipment4, wednesdayCheckBox.text.toString())
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName4, equipment4, thursdayCheckBox.text.toString())
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName4, equipment4, fridayCheckBox.text.toString())
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName4, equipment4, saturdayCheckBox.text.toString())
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName4, equipment4, sundayCheckBox.text.toString())
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else if (checkBoxWorkout5.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName5, equipment5, mondayCheckBox.text.toString())
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName5, equipment5, tuesdayCheckBox.text.toString())
            }else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName5, equipment5, wednesdayCheckBox.text.toString())
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName5, equipment5, thursdayCheckBox.text.toString())
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName5, equipment5, fridayCheckBox.text.toString())
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName5, equipment5, saturdayCheckBox.text.toString())
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName5, equipment5, sundayCheckBox.text.toString())
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else if (checkBoxWorkout6.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName6, equipment6, mondayCheckBox.text.toString())
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName6, equipment6, tuesdayCheckBox.text.toString())
            }else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName6, equipment6, wednesdayCheckBox.text.toString())
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName6, equipment6, thursdayCheckBox.text.toString())
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName6, equipment6, fridayCheckBox.text.toString())
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName6, equipment6, saturdayCheckBox.text.toString())
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName6, equipment6, sundayCheckBox.text.toString())
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else if (checkBoxWorkout7.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName7, equipment7, mondayCheckBox.text.toString())
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName7, equipment7, tuesdayCheckBox.text.toString())
            }else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName7, equipment7, wednesdayCheckBox.text.toString())
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName7, equipment7, thursdayCheckBox.text.toString())
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName7, equipment7, fridayCheckBox.text.toString())
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName7, equipment7, saturdayCheckBox.text.toString())
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName7, equipment7, sundayCheckBox.text.toString())
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else if (checkBoxWorkout8.isChecked) {
            if (mondayCheckBox.isChecked) {
                addDataForWorkout(workoutName8, equipment8, mondayCheckBox.text.toString())
            } else if (tuesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName8, equipment8, tuesdayCheckBox.text.toString())
            }else if (wednesdayCheckBox.isChecked) {
                addDataForWorkout(workoutName8, equipment8, wednesdayCheckBox.text.toString())
            } else if (thursdayCheckBox.isChecked) {
                addDataForWorkout(workoutName8, equipment8, thursdayCheckBox.text.toString())
            }else if (fridayCheckBox.isChecked) {
                addDataForWorkout(workoutName8, equipment8, fridayCheckBox.text.toString())
            }else if (saturdayCheckBox.isChecked) {
                addDataForWorkout(workoutName8, equipment8, saturdayCheckBox.text.toString())
            }else if (sundayCheckBox.isChecked) {
                addDataForWorkout(workoutName8, equipment8, sundayCheckBox.text.toString())
            }
            else {
                Toast.makeText(this, "You need to pick a weekday", Toast.LENGTH_LONG).show()
            }
        }

        else {
            Toast.makeText(this, "You need to pick an Exercise", Toast.LENGTH_LONG).show()
        }
    }

}


