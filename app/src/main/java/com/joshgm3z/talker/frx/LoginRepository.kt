package com.joshgm3z.talker.frx

import com.joshgm3z.talker.common.firestore.FirestoreManager
import com.joshgm3z.talker.common.room.TalkerDb
import com.joshgm3z.talker.common.room.entity.User
import com.joshgm3z.talker.common.utils.SharedPref

class LoginRepository(
    private val firestoreManager: FirestoreManager,
    private val sharedPref: SharedPref,
) {

    fun checkUsername(
        username: String,
        onUserFound: () -> Unit,
        onUserNotFound: () -> Unit,
        onError: (message: String) -> Unit,
    ) {
        onUserNotFound()
    }

    fun registerUser(
        user: User,
        onComplete: () -> Unit,
        onError: (message: String) -> Unit,
    ) {
        firestoreManager.registerUser(
            user,
            onSuccess = {
                saveCurrentUserDetails(it)
                onComplete()
            },
            onError = {
                onError(it)
            })
    }

    private fun saveCurrentUserDetails(user: User) {
        sharedPref.setCurrentUser(user)
    }

}