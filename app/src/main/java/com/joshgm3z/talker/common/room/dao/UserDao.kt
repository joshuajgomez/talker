package com.joshgm3z.talker.common.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.joshgm3z.talker.common.room.entity.Chat
import com.joshgm3z.talker.common.room.entity.User

@Dao
interface UserDao {

    @Query("select * from User where id = :userId")
    suspend fun getUser(userId: Int): User

    @Query("select * from User")
    suspend fun getAllUsers(): List<User>

}
