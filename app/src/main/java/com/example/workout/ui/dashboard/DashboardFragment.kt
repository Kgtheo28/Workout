package com.example.workout.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.workout.R
import com.example.workout.database.ExerciseViewModel
import com.example.workout.database.data.Exercise
import com.example.workout.databinding.FragmentDashboardBinding

open class DashboardFragment : Fragment() {

    private lateinit var mUserViewModel: ExerciseViewModel

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        mUserViewModel = ViewModelProvider(this).get(ExerciseViewModel::class.java)

        binding.addButton1.setOnClickListener {
            //findNavController().navigate(R.id.action_navigation_dashboard_to_addExerciseFragment)
            //insertData()
        }

        binding.buttonAdd2.setOnClickListener {
            //insertData2()
        }

        binding.addButton3.setOnClickListener {
            //insertData3()
        }

        binding.addButton4.setOnClickListener {
            //insertData4()
        }

        binding.addButton5.setOnClickListener {
            //insertData5()
        }

        binding.addButton6.setOnClickListener {
            //insertData6()
        }

        binding.addButton7.setOnClickListener {
            //insertData7()
        }

        binding.addButton8.setOnClickListener {
            //insertData8()
        }

        return root
    }

    /*
    private fun insertData() {
        val bodyPart = binding.workoutName1.text.toString()
        val exerciseName = binding.equipment1.text.toString()
        val exercise = Exercise(bodyPart, exerciseName, 1)

        // Add data to database
        mUserViewModel.addExercise(exercise)
        Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
        //Navigate back to Notification Fragment
        findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_notifications)
    }

    private fun insertData2(){
        val bodyPart = binding.workoutName2.text.toString()
        val exerciseName = binding.equipment2.text.toString()
        val exercise = Exercise(bodyPart, exerciseName,2)
        // Add data to database
        mUserViewModel.addExercise(exercise)
        Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
        //Navigate back to Notification Fragment
        findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_notifications)
    }

    private fun insertData3(){
        val bodyPart = binding.workoutName3.text.toString()
        val exerciseName = binding.equipment3.text.toString()
        val exercise = Exercise(bodyPart, exerciseName,3)
        // Add data to database
        mUserViewModel.addExercise(exercise)
        Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
        //Navigate back to Notification Fragment
        findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_notifications)
    }

    private fun insertData4(){
        val bodyPart = binding.workoutName4.text.toString()
        val exerciseName = binding.equipment4.text.toString()
        val exercise = Exercise(bodyPart, exerciseName,4)
        // Add data to database
        mUserViewModel.addExercise(exercise)
        Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
        //Navigate back to Notification Fragment
        findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_notifications)
    }

    private fun insertData5(){
        val bodyPart = binding.workoutName5.text.toString()
        val exerciseName = binding.equipment5.text.toString()
        val exercise = Exercise(bodyPart, exerciseName,5)
        // Add data to database
        mUserViewModel.addExercise(exercise)
        Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
        //Navigate back to Notification Fragment
        findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_notifications)
    }

    private fun insertData6(){
        val bodyPart = binding.workoutName6.text.toString()
        val exerciseName = binding.equipment6.text.toString()
        val exercise = Exercise(bodyPart, exerciseName,6)
        // Add data to database
        mUserViewModel.addExercise(exercise)
        Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
        //Navigate back to Notification Fragment
        findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_notifications)
    }

    private fun insertData7(){
        val bodyPart = binding.workoutName7.text.toString()
        val exerciseName = binding.equipment7.text.toString()
        val exercise = Exercise(bodyPart, exerciseName,7)
        // Add data to database
        mUserViewModel.addExercise(exercise)
        Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
        //Navigate back to Notification Fragment
        findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_notifications)
    }

    private fun insertData8(){
        val bodyPart = binding.workoutName8.text.toString()
        val exerciseName = binding.equipment8.text.toString()
        val exercise = Exercise(bodyPart, exerciseName,8)
        // Add data to database
        mUserViewModel.addExercise(exercise)
        Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
        //Navigate back to Notification Fragment
        findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_notifications)
    }

     */
}