package com.joshgm3z.talker.common.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.joshgm3z.talker.common.utils.getPrettyTime

@Entity
data class Chat(
    var message: String,
    var toUserId: String,
    var sentTime: Long,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var fromUserId: String = ""
    var deliveredTime: Long = 0

    fun getTextTime() = getPrettyTime(sentTime)
    fun isFrom(): Boolean = fromUserId.isEmpty()
}
