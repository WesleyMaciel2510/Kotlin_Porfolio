package com.example.kotlin_portfolio.screens.newScreen.logic

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NewScreenLogic : ViewModel() {
    val loading = mutableStateOf(false)

    //private val _isAuthenticated = mutableStateOf(false)
    //val isAuthenticated: MutableState<Boolean> get() = _isAuthenticated

    fun exampleFunction() {
        Log.d("LOGIN", "@@ exampleFunction called")
    }
}