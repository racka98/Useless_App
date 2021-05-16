package com.rackaapps.uselessapp.loginscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.rackaapps.uselessapp.R
import com.rackaapps.uselessapp.databinding.FragmentLoginScreenBinding


class LoginScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginScreenBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_login_screen, container, false
        )

        binding.login.setOnClickListener {
            if (
                binding.username.text.toString().isNotEmpty() &&
                binding.password.text.toString().isNotEmpty()
            ) {
                it.findNavController().navigate(LoginScreenDirections.actionLoginScreenToUselessScreen())
            } else {
                Toast.makeText(context, "Field(s) can not be empty", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

}