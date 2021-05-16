package com.rackaapps.uselessapp.uselessscreen

import androidx.appcompat.widget.SwitchCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

val ALL_TRUE = List(9) { true }


class UselessScreenViewModel : ViewModel() {
    private lateinit var switchList: MutableList<Boolean>

    private val _switchState = MutableLiveData<MutableList<Boolean>>()
    val switchState: LiveData<MutableList<Boolean>> = _switchState

    //Boolean for when all switches are ON
    private val _eventAllSwitchesOn = MutableLiveData<Boolean>()
    val eventAllSwitchesOn: LiveData<Boolean> = _eventAllSwitchesOn

    init {
        _eventAllSwitchesOn.value = false
        resetAllSwitches()
    }

    fun randomizeSwitches() {
        switchList = mutableListOf(
            Random.nextBoolean(),
            Random.nextBoolean(),
            Random.nextBoolean(),
            Random.nextBoolean(),
            Random.nextBoolean(),
            Random.nextBoolean(),
            Random.nextBoolean(),
            Random.nextBoolean(),
            Random.nextBoolean()
        )
        _switchState.value = switchList
        if (switchList.containsAll(ALL_TRUE)) _eventAllSwitchesOn.value = true
    }


    private fun resetAllSwitches() {
        switchList = MutableList(9) { false }
    }
    fun onEventAllSwitchesOnCompleted() {
        _eventAllSwitchesOn.value = false
    }
}