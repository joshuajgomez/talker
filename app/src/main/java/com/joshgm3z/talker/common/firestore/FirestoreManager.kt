package com.joshgm3z.talker.common.firestore

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.joshgm3z.talker.common.room.entity.User

class FirestoreManager {

    private val collectionUsers = "users"
    private val fieldId = "id"
    private val fieldName = "name"
    private val fieldPictureUrl = "picture_url"

    private val firestoreDb = Firebase.firestore

    fun registerUser(
        user: User,
        onSuccess: (user: User) -> Unit,
        onError: (message: String) -> Unit,
    ) {
        val userMap = hashMapOf(
            fieldName to user.name,
            fieldPictureUrl to user.pictureUrl,
        )
        firestoreDb.collection(collectionUsers)
            .add(userMap)
            .addOnSuccessListener {
                user.id = it.id
                onSuccess(user)
            }
            .addOnFailureListener { e -> onError("Error writing document: " + e.message) }
    }

}