package com.joshgm3z.talker.common.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.joshgm3z.talker.common.room.entity.Chat

@Dao
interface ChatDao {

    @Insert
    suspend fun insert(chat: Chat)

    @Query("select * from Chat where toUserId = :userId or fromUserId = :userId")
    fun getChatsWithUser(userId: Int): LiveData<List<Chat>>

    @Query("select * from Chat")
    fun getAllChats(): LiveData<List<Chat>>
}