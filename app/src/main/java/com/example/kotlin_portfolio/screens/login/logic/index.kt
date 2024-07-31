package com.example.kotlin_portfolio.screens.login.logic

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginLogic : ViewModel() {
    private val _isAuthenticated = MutableStateFlow(true)
    val isAuthenticated: StateFlow<Boolean> get() = _isAuthenticated

    fun handleLogin(username: String, password: String, onResult: (Boolean) -> Unit) {
        Log.d("LOGIN", "@@ HandleLogin called")
        Log.d("LOGIN", "Logging in with username: $username ")
        Log.d("LOGIN", "Logging in with password: $password")

        val result = (username == "wesley2510" && password == "test123")
        _isAuthenticated.value = result
        Log.d("LOGIN", "Result of Boolean Validation = $result")
        Log.d("LOGIN", "isAuthenticated = ${isAuthenticated.value}")

        //return the result
        onResult(result)
    }
}
