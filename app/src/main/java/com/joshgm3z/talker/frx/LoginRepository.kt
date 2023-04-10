package com.joshgm3z.talker.frx

import com.joshgm3z.talker.common.firestore.FirestoreManager
import com.joshgm3z.talker.common.room.TalkerDb
import com.joshgm3z.talker.common.room.entity.User

class LoginRepository(
    private val talkerDb: TalkerDb,
    private val firestoreManager: FirestoreManager,
) {

    fun checkUsername(username: String) {

    }

    fun registerUser(
        user: User,
        onComplete: () -> Unit,
        onError: (message: String) -> Unit,
    ) {
        firestoreManager.registerUser(
            user,
            onSuccess = {
                saveCurrentUserDetails()
                onComplete
            },
            onError = {
                onError(it)
            })
    }

    private fun saveCurrentUserDetails(user: User) {

    }

}