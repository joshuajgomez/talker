package com.joshgm3z.talker.frx

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.joshgm3z.talker.common.room.entity.User

class LoginViewModel(private val loginRepo: LoginRepository) : ViewModel() {

    val statusMessage = mutableStateOf("")

    fun onLoginClick(
        username: String,
        onLoginComplete: () -> Unit,
        onLoginError: (message: String) -> Unit,
    ) {
        loginRepo.checkUsername(
            username,
            onUserFound = {},
            onUserNotFound = { createNewUser(username, onLoginComplete, onLoginError) },
            onError = {}
        )
    }

    private fun createNewUser(
        username: String,
        onLoginComplete: () -> Unit,
        onLoginError: (message: String) -> Unit,
    ) {
        val user = User("", username, "")
        loginRepo.registerUser(
            user,
            onComplete = { onLoginComplete() },
            onError = { onLoginError(it) })
    }
}