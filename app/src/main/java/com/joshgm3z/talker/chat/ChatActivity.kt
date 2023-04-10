package com.joshgm3z.talker.chat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joshgm3z.talker.chat.ui.ChatScreen
import com.joshgm3z.talker.chat.ui.theme.TalkerTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TalkerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel by viewModel<ChatViewModel>()
                    ChatScreen(
                        toUser = viewModel.chatUser,
                        chatListLive = viewModel.chatList,
                        onClickSend = { viewModel.onClickSend(it) }
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
        ChatScreen()
    }
}