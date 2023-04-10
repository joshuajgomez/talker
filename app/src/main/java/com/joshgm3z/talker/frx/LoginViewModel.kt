package com.joshgm3z.talker.frx

import androidx.lifecycle.ViewModel

class LoginViewModel(private val loginRepo: LoginRepository) : ViewModel() {

    fun onLoginClick(username: String) {
        loginRepo.checkUsername(username)
    }
}