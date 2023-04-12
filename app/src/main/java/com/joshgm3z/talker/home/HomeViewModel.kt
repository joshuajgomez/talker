package com.joshgm3z.talker.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joshgm3z.talker.chat.ChatRepository
import com.joshgm3z.talker.common.room.entity.Chat
import com.joshgm3z.talker.common.room.entity.User
import com.joshgm3z.talker.common.utils.SharedPref
import kotlinx.coroutines.launch

class HomeViewModel(
    private val chatRepo: ChatRepository,
    private val sharedPref: SharedPref,
) : ViewModel() {

    private lateinit var homeChatList: ArrayList<HomeChat>
    private lateinit var userList: List<User>

    init {
        viewModelScope.launch {
            userList = chatRepo.getAllUsers()
        }
        chatRepo.getAllChats().observeForever {
            updateHomeChatList(it)
        }
    }

    fun isCurrentUserSaved() = sharedPref.isCurrentUserSaved()

    private fun updateHomeChatList(chatList: List<Chat>?) {
        chatList?.forEach { chat ->
            var isFound = false
            val userId = chat.fromUserId.ifEmpty { chat.toUserId }
            homeChatList.forEachIndexed { index, homeChat ->
                if (userId == homeChat.user.id) {
                    // user already added. update chat and increment message count
                    isFound = true
                    homeChatList[index].chat = chat
                    homeChatList[index].messageCount++
                }
            }
            if (!isFound) {
                val homeChat = HomeChat(
                    chat = chat,
                    user = getUser(userId)!!,
                    status = HomeChat.WAITING
                )
                homeChatList.add(homeChat)
            }
        }
    }

    private fun getUser(userId: String): User? {
        userList.forEach {
            if (it.id == userId) {
                return it
            }
        }
        return null
    }

    fun onChatClick(user: User) {

    }
}