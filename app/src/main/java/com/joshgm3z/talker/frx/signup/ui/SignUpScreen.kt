package com.joshgm3z.talker.frx.signup.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joshgm3z.talker.common.const.ScreenSignUp
import com.joshgm3z.talker.frx.ui.Loading
import com.joshgm3z.talker.frx.ui.NewUser

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenSignUp.NewUser.route) {
        composable(route = ScreenSignUp.NewUser.route) {
            NewUser()
        }
        composable(route = ScreenSignUp.Loading.route) {
            Loading(text = "Signing up")
        }
    }
}