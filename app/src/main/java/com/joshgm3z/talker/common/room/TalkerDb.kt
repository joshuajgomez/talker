package com.joshgm3z.talker.common.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joshgm3z.talker.common.room.dao.ChatDao
import com.joshgm3z.talker.common.room.dao.UserDao
import com.joshgm3z.talker.common.room.entity.Chat
import com.joshgm3z.talker.common.room.entity.User

@Database(
    entities = [Chat::class, User::class],
    version = 1,
    exportSchema = false
)
abstract class TalkerDb : RoomDatabase() {

    abstract fun chatDao(): ChatDao

    abstract fun userDao(): UserDao

}