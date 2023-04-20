package com.joshgm3z.talker.frx.ui

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joshgm3z.talker.common.const.ScreenLogin

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreen(
    onLoginClick: (username: String) -> Unit = {},
    onOpenGalleryClick: () -> Unit = {},
    onTakePhotoClick: () -> Unit = {},
    onGoBackClick: () -> Unit = {},
    onSignUpClick: () -> Unit = {},
    signupStatus: () -> Unit = {},
) {
    Surface {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = ScreenLogin.UsernameInput.route
        ) {
            composable(route = ScreenLogin.UsernameInput.route) {
                UsernameInput(navController = navController)
            }
            composable(route = ScreenLogin.Loading.route) {
                Loading()
            }
        }
    }
}