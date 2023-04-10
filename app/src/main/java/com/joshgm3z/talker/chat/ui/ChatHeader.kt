package com.joshgm3z.talker.chat.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joshgm3z.talker.R
import com.joshgm3z.talker.common.room.entity.User
import com.joshgm3z.talker.chat.ui.theme.Gray40
import com.joshgm3z.talker.common.utils.getRandomUser

@Composable
fun ChatHeader(user: User) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Gray40)
            .padding(top = 10.dp, bottom = 10.dp)
    ) {
        val horizontalSpacing = 15.dp
        Spacer(modifier = Modifier.width(horizontalSpacing))
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "go back"
        )
        Spacer(modifier = Modifier.width(horizontalSpacing))
        Image(
            painter = painterResource(id = R.drawable.sample_user),
            contentDescription = "profile picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp)
        )
        Spacer(modifier = Modifier.width(horizontalSpacing))
        Text(
            text = user.name,
            fontSize = 23.sp,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.width(horizontalSpacing))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewChatHeader() {
    Column {
        ChatHeader(user = getRandomUser())
        Surface(Modifier.weight(1F)) {}
    }
}