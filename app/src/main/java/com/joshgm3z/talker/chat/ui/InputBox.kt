package com.joshgm3z.talker.chat.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joshgm3z.talker.chat.ui.theme.Gray40
import com.joshgm3z.talker.chat.ui.theme.Green40

@Composable
fun InputBox(onClickSend: (message: String) -> Unit = {}) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Gray40)
            .padding(all = 10.dp),
    ) {
        var text by remember { mutableStateOf("") }
        Card(
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .weight(1F)
        ) {
            TextField(
                value = text,
                placeholder = { Text(text = "Type message") },
                onValueChange = { text = it },
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .background(Color.Transparent),
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            tint = Green40,
            imageVector = Icons.Rounded.Send,
            contentDescription = "send",
            modifier = Modifier
                .size(70.dp)
                .padding(5.dp)
                .clickable(enabled = text.isNotEmpty()) {
                    onClickSend(text)
                    text = ""
                }
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewInputBox() {
    Column {
        Surface(Modifier.weight(1F)) {}
        InputBox()
    }
}