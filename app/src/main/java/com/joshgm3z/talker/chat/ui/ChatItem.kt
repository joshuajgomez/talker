package com.joshgm3z.talker.chat.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joshgm3z.talker.common.room.entity.Chat
import com.joshgm3z.talker.chat.ui.theme.Blue40
import com.joshgm3z.talker.chat.ui.theme.Green40
import com.joshgm3z.talker.common.utils.getRandomChat

@Composable
fun ChatItem(chat: Chat) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (chat.isFrom()) Arrangement.End else Arrangement.Start
    ) {
        Card(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(if (chat.isFrom()) Green40 else Blue40)
                    .padding(all = 5.dp)
            ) {
                Text(
                    text = chat.message,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Text(
                    text = chat.getTextTime(),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewChatItem() {
    Surface {
        Column {
            ChatItem(getRandomChat(false))
            ChatItem(getRandomChat(true))
            ChatItem(getRandomChat(true))
        }
    }
}