package com.joshgm3z.talker.chat

import androidx.lifecycle.LiveData
import com.joshgm3z.talker.common.room.TalkerDb
import com.joshgm3z.talker.common.room.entity.Chat
import com.joshgm3z.talker.common.room.entity.User

class ChatRepository(private val talkerDb: TalkerDb) {

    fun getChatsWithUser(user: User): LiveData<List<Chat>> =
        talkerDb.chatDao().getChatsWithUser(user.id)

    suspend fun addChat(chat: Chat) =
        talkerDb.chatDao().insert(chat)

    suspend fun getUser(userId: Int): User = talkerDb.userDao()
        .getUser(userId)

    fun getAllChats(): LiveData<List<Chat>> = talkerDb.chatDao().getAllChats()

    suspend fun getAllUsers(): List<User> = talkerDb.userDao().getAllUsers()
}