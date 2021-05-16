package com.rackaapps.uselessapp.uselessscreen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.rackaapps.uselessapp.R
import com.rackaapps.uselessapp.databinding.UselessScreenFragmentBinding

class UselessScreen : Fragment() {

    private lateinit var viewModel: UselessScreenViewModel

    private lateinit var binding: UselessScreenFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.useless_screen_fragment, container, false)
        

        //Requesting ViewModel
        viewModel = ViewModelProvider(this).get(UselessScreenViewModel::class.java)
        binding.uselessScreenViewModel = viewModel

        //Setting the lifecycle owner
        binding.lifecycleOwner = this


        //Initiate navigation
        //Turn this on and it will be basically impossible to finish the thing.
//        viewModel.eventAllSwitchesOn.observe(viewLifecycleOwner, Observer { allOn ->
//            if (allOn) {
//                navigateToNextScreen()
//                viewModel.onEventAllSwitchesOnCompleted()
//            }
//        })

        //Loop hole by sliding the switches and not tapping
        binding.verifyButton.setOnClickListener {
            val switchesState = listOf(
                binding.switch1.isChecked,
                binding.switch2.isChecked,
                binding.switch3.isChecked,
                binding.switch4.isChecked,
                binding.switch5.isChecked,
                binding.switch6.isChecked,
                binding.switch7.isChecked,
                binding.switch8.isChecked,
                binding.switch9.isChecked,
            )
            if (switchesState == ALL_TRUE) navigateToNextScreen()
            else Toast.makeText(context, "You are not done yet dummy!", Toast.LENGTH_SHORT).show()
        }


        return binding.root
    }

    private fun navigateToNextScreen() {
        val action = UselessScreenDirections.actionUselessScreenToFinishScreen()
        findNavController().navigate(action)
    }


}