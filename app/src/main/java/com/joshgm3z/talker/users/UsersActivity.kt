package com.joshgm3z.talker.users

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.joshgm3z.talker.users.ui.UserScreen
import com.joshgm3z.talker.users.ui.theme.TalkerTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fun onCloseClick() {
            ActivityCompat.finishAffinity(this)
        }
        setContent {
            TalkerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val usersViewModel by viewModel<UsersViewModel>()
                    UserScreen(
                        userList = usersViewModel.userList,
                        onCloseClick = { onCloseClick() },
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
        UserScreen()
    }
}