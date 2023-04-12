package com.joshgm3z.talker.common.utils

import android.content.Context
import android.content.SharedPreferences
import com.joshgm3z.talker.common.room.entity.User

class SharedPref(private val context: Context) {

    private val prefName = "talker-shared-prefs"

    private val keyUserId = "keyUserId"

    private val keyUserName = "keyUserName"

    private val keyUserPicture = "keyUserPicture"

    private fun get(): SharedPreferences {
        return context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    fun getCurrentUser(): User {
        val sharedPreferences = get()
        val id: String = sharedPreferences.getString(keyUserId, "")!!;
        val name: String = sharedPreferences.getString(keyUserName, "")!!;
        val pictureUrl: String = sharedPreferences.getString(keyUserPicture, "")!!;
        return User(id = id, name = name, pictureUrl = pictureUrl)
    }

    fun isCurrentUserSaved(): Boolean = get().contains(keyUserId)

    fun setCurrentUser(user: User) {
        val editor = get().edit()
        editor.putString(keyUserId, user.id)
        editor.putString(keyUserName, user.name)
        editor.putString(keyUserPicture, user.pictureUrl)
        editor.apply()
    }

}