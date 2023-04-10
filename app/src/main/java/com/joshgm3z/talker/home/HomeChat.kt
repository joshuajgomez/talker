package com.joshgm3z.talker.home

import com.joshgm3z.talker.common.room.entity.Chat
import com.joshgm3z.talker.common.room.entity.User

data class HomeChat(
    var chat: Chat,
    val user: User,
    val status: Int,
) {
    var messageCount: Int = 0

    var isTyping: Boolean = false

    fun isUnread(): Boolean = messageCount > 0

    companion object Status {
        const val DEFAULT = 0
        const val WAITING = 1
        const val SENT = 2
        const val DELIVERED = 3
        const val SEEN = 4
    }
}
