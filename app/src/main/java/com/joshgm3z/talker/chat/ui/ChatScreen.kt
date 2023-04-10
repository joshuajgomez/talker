package com.joshgm3z.talker.chat.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.joshgm3z.talker.common.room.entity.Chat
import com.joshgm3z.talker.common.room.entity.User
import com.joshgm3z.talker.common.utils.getRandomChatList
import com.joshgm3z.talker.common.utils.getRandomUser

@Composable
fun ChatScreen(
    toUser: User = getRandomUser(),
    chatListLive: LiveData<List<Chat>> = MutableLiveData(),
    onClickSend: (message: String) -> Unit = {},
) {
    Column {
        ChatHeader(user = toUser)
        Surface(modifier = Modifier.weight(1F)) {
            val chatList =
                if (isInPreview()) getRandomChatList()
                else chatListLive.observeAsState(listOf()).value
            ChatList(chatList)
        }
        InputBox(onClickSend)
    }
}

@Composable
fun ChatList(chatList: List<Chat>) {
    LazyColumn() {
        items(items = chatList) {
            ChatItem(chat = it)
        }
    }
}

@Composable
fun isInPreview(): Boolean = LocalInspectionMode.current

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewChatScreen() {
    ChatScreen()
}