package com.joshgm3z.talker.frx.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.joshgm3z.talker.common.const.ScreenLogin
import com.joshgm3z.talker.home.ui.Title

@Preview
@Composable
fun UsernameInput(
    onLoginClick: (username: String) -> Unit = {},
    navController: NavController = rememberNavController(),
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Welcome to",
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic
        )

        Title()

        Spacer(modifier = Modifier.height(60.dp))

        var username by remember { mutableStateOf("") }
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = {
                Text(text = "Enter username")
            }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {
            onLoginClick(username)
            navController.navigate(ScreenLogin.Loading.route)
        }) {
            Text(text = "Login")
        }
    }
}