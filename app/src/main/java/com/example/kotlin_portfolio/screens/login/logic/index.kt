package com.example.kotlin_portfolio.screens.login.logic

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

class LoginLogic : ViewModel() {
    val isAuthenticated = mutableStateOf(false)

    //private val _isAuthenticated = mutableStateOf(false)
    //val isAuthenticated: MutableState<Boolean> get() = _isAuthenticated

    fun handleLogin(username: String, password: String, onResult: (Boolean) -> Unit) {
        Log.d("LOGIN", "@@ HandleLogin called")
        Log.d("LOGIN", "Logging in with username: $username and password: $password")

        val result = (username == "wesley2510" && password == "test123")
        isAuthenticated.value = result
        Log.d("LOGIN", "Result of Boolean Validation = $result")
        Log.d("LOGIN", "isAuthenticated = ${isAuthenticated.value}")

        //return the result
        onResult(result)
    }
}
