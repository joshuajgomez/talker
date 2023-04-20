package com.joshgm3z.talker.common.const

sealed class ScreenLogin(val route: String) {
    object UsernameInput : ScreenLogin("login_username_input")
    object Loading : ScreenLogin("login_loading")
}

sealed class ScreenSignUp(val route: String) {
    object NewUser : ScreenSignUp("signup_new_user")
    object Loading : ScreenSignUp("signup_loading")
}
