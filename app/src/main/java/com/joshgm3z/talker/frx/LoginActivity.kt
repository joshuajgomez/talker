package com.joshgm3z.talker.frx

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.joshgm3z.talker.frx.ui.LoginScreen
import com.joshgm3z.talker.frx.ui.theme.TalkerTheme
import com.joshgm3z.talker.home.HomeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TalkerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    fun onLoginSuccess() {
                        ActivityCompat.finishAffinity(this)
                        val myIntent = Intent(this, HomeActivity::class.java)
                        startActivity(myIntent)
                    }

                    fun onLoginError(message: String) {
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                    }

                    val loginViewModel by viewModel<LoginViewModel>()
                    LoginScreen(
                        onLoginClick = { userName ->
                            loginViewModel.onLoginClick(
                                userName,
                                onLoginComplete = { onLoginSuccess() },
                                onLoginError = { onLoginError(it) },
                            )
                        }
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TalkerTheme {
        LoginScreen()
    }
}