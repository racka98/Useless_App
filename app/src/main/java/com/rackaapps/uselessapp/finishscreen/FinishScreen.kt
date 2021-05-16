package com.rackaapps.uselessapp.finishscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.rackaapps.uselessapp.R
import com.rackaapps.uselessapp.databinding.FragmentFinishScreenBinding


class FinishScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentFinishScreenBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_finish_screen, container, false
        )
        return binding.root
    }

}