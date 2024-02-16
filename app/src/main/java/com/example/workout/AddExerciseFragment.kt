package com.example.workout

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.workout.database.ExerciseViewModel
import com.example.workout.databinding.FragmentAddExerciseBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AddExerciseFragment : Fragment() {

    private lateinit var mUserViewModel: ExerciseViewModel

    private var _binding: FragmentAddExerciseBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddExerciseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding.addExerciseBtn.setOnClickListener {
            insertData()
        }

        return root
    }

    private fun insertData() {
        val weekday = binding.tvWeekday.text.toString()
        val exerciseName = binding.tvWorkoutName.text.toString()
        val bodyPart = binding.tvBodyPart.text.toString()


        if(inputCheck(weekday, exerciseName)){
            // create Exercise Object
            //val weekdays = Weekdays(weekday, 1)
            //val crossRef = WeekdaysExerciseCrossRef(1, 1)
            //val exercise = Exercise(bodyPart,exerciseName, 1)
            // Add data to database
            //weekdaysViewModel.addWeekday(weekdays)
            //mUserViewModel.addExercise(exercise)
            //mUserViewModel.insertWorkoutMondayCrossRef(crossRef)

            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
            //Navigate back to Notification Fragment
            findNavController().navigate(R.id.action_addExerciseFragment_to_navigation_home)
        }else{
            Toast.makeText(requireContext(), "please fill out all input", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(weekday: String, exerciseName: String): Boolean{
       return !((TextUtils.isEmpty(weekday)  && TextUtils.isEmpty(exerciseName)))
    }


}