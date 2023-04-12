package com.joshgm3z.talker.home

import android.content.Intent
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
import com.joshgm3z.talker.frx.LoginActivity
import com.joshgm3z.talker.home.ui.HomeScreen
import com.joshgm3z.talker.home.ui.theme.TalkerTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val homeViewModel by viewModel<HomeViewModel>()
        if (!homeViewModel.isCurrentUserSaved()) {
            ActivityCompat.finishAffinity(this)
            val myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
        } else {
            setContent {
                TalkerTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        HomeScreen(
//                        homeChatListLive = homeViewModel.homeChatList,
                            onChatClick = { homeViewModel.onChatClick(it) }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TalkerTheme {
        HomeScreen()
    }
}