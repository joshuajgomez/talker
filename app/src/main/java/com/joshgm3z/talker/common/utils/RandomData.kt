package com.joshgm3z.talker.common.utils

import com.joshgm3z.talker.home.HomeChat
import com.joshgm3z.talker.common.room.entity.Chat
import com.joshgm3z.talker.common.room.entity.User
import kotlin.random.Random

fun getRandomChat(isFrom: Boolean = true, message: String = "Hello guys"): Chat {
    val chat = Chat(
        message = message,
        toUserId = if (isFrom) getRandomUser().id else "",
        sentTime = System.currentTimeMillis()
    )
    chat.fromUserId = if (isFrom) "" else getRandomUser().id
    chat.deliveredTime = System.currentTimeMillis() + 10
    return chat
}

fun getRandomUser() = User(
    id = System.currentTimeMillis().toString(),
    name = "Some guy HJHJHJHK KLKLKL #" + Random.nextInt(),
    pictureUrl = "link/to/some_pic.jpg"
)


fun getRandomHomeChat(
    isTyping: Boolean = false,
    messageCount: Int = 0,
    status: Int = HomeChat.DELIVERED,
): HomeChat {
    return HomeChat(
        chat = getRandomChat(message = "Some really long message was sent from someone special"),
        user = getRandomUser(),
        status = status
    )
}

fun getRandomHomeChatList() = listOf(
    getRandomHomeChat(status = HomeChat.WAITING),
    getRandomHomeChat(messageCount = 3),
    getRandomHomeChat(isTyping = true, messageCount = 500),
    getRandomHomeChat(isTyping = true),
    getRandomHomeChat(status = HomeChat.SENT),
    getRandomHomeChat(status = HomeChat.DELIVERED),
    getRandomHomeChat(status = HomeChat.SEEN),
    getRandomHomeChat(status = HomeChat.DEFAULT),
    getRandomHomeChat(),
)


fun getRandomChatList() = listOf(
    getRandomChat(),
    getRandomChat(false),
    getRandomChat(),
    getRandomChat(false),
    getRandomChat(false),
    getRandomChat(),
    getRandomChat(),
)