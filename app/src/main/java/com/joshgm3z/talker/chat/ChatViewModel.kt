package com.joshgm3z.talker.chat

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joshgm3z.talker.common.room.entity.Chat
import com.joshgm3z.talker.common.room.entity.User
import com.joshgm3z.talker.common.utils.getRandomUser
import kotlinx.coroutines.launch

class ChatViewModel(private val chatRepo: ChatRepository) : ViewModel() {

    lateinit var chatUser: User

    init {
        viewModelScope.launch {
            chatUser = chatRepo.getUser(1291027203);
        }
    }

    val chatList = chatRepo.getChatsWithUser(chatUser)

    fun onClickSend(message: String) {
        Log.println(Log.ASSERT, "ChatViewModel", "onClickSend: message= $message")
        val chat = Chat(
            message = message,
            toUserId = chatUser.id,
            sentTime = System.currentTimeMillis()
        )
        chat.message = message
        viewModelScope.launch {
            chatRepo.addChat(chat)
        }
    }
}