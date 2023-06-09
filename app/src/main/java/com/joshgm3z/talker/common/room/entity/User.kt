package com.joshgm3z.talker.common.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = false)
    var id: String,
    val name: String,
    val pictureUrl: String,
)
