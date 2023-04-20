package com.joshgm3z.talker.common

import androidx.lifecycle.LiveData
import com.joshgm3z.talker.common.firestore.FirestoreManager
import com.joshgm3z.talker.common.room.TalkerDb
import com.joshgm3z.talker.common.room.entity.Chat
import com.joshgm3z.talker.common.room.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TalkerRepository(
    private val talkerDb: TalkerDb,
    private val firestoreManager: FirestoreManager,
) {

    suspend fun updateUserList() {
//        firestoreManager.fetchUserList {
//            withContext(Dispatchers.IO) {
//                talkerDb.userDao().addUsers(it)
//            }
//        }
    }

    fun getChatsWithUser(user: User): LiveData<List<Chat>> =
        talkerDb.chatDao().getChatsWithUser(user.id)

    suspend fun addChat(chat: Chat) =
        talkerDb.chatDao().insert(chat)

    suspend fun getUser(userId: Int): User = talkerDb.userDao()
        .getUser(userId)

    fun getAllChats(): LiveData<List<Chat>> = talkerDb.chatDao().getAllChats()

    suspend fun getAllUsers(): List<User> = talkerDb.userDao().getAllUsers()
}