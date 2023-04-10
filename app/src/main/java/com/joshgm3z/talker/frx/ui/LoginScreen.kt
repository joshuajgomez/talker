package com.joshgm3z.talker.frx.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joshgm3z.talker.home.ui.Title

@Composable
fun LoginScreen(onLoginClick: (username: String) -> Unit = {}) {
    Surface {

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

            Button(onClick = { onLoginClick(username) }) {
                Text(text = "Login")
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PreviewLoginScreen() {
    LoginScreen()
}
