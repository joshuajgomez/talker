package com.joshgm3z.talker.home.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.DoneAll
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.joshgm3z.talker.R
import com.joshgm3z.talker.chat.ui.theme.*
import com.joshgm3z.talker.home.HomeChat
import com.joshgm3z.talker.common.room.entity.User
import com.joshgm3z.talker.common.utils.getRandomHomeChat
import com.joshgm3z.talker.common.utils.getRandomHomeChatList

@Composable
fun HomeItem(
    homeChat: HomeChat,
    onChatClick: (user: User) -> Unit = {},
) {
    Surface(onClick = { onChatClick(homeChat.user) }) {
        ConstraintLayout(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, bottom = 0.dp)
        ) {
            val (
                profilePicture,
                message,
                name,
                messageCount,
                sentTime,
                sentTick,
                bottomDivider,
            ) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.sample_user),
                contentDescription = "profile picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp)
                    .constrainAs(profilePicture) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
            )
            Text(
                text = homeChat.user.name,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .constrainAs(name) {
                        top.linkTo(profilePicture.top)
                        start.linkTo(profilePicture.end, margin = 10.dp)
                    }
                    .fillMaxWidth(0.65F))

            val isShowTick: Boolean = homeChat.status != HomeChat.DEFAULT

            AnimatedVisibility(
                visible = isShowTick,
                modifier = Modifier
                    .constrainAs(sentTick) {
                        top.linkTo(name.bottom, margin = 3.dp)
                        start.linkTo(name.start)
                    }) {
                StatusIcon(homeChat.status)
            }

            Text(
                text = homeChat.chat.message,
                fontSize = 17.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = if (homeChat.isUnread()) FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier
                    .constrainAs(message) {
                        top.linkTo(name.bottom)
                        if (isShowTick) start.linkTo(sentTick.end, margin = 3.dp)
                        else start.linkTo(name.start)
                    }
                    .fillMaxWidth(0.6f)
            )

            Text(
                text = homeChat.chat.getTextTime(),
                fontSize = 15.sp,
                color = if (homeChat.isUnread()) Green50 else Color.Black,
                modifier = Modifier.constrainAs(sentTime) {
                    top.linkTo(name.top)
                    end.linkTo(parent.end)
                })

            AnimatedVisibility(
                visible = homeChat.isUnread(),
                modifier = Modifier
                    .constrainAs(messageCount) {
                        end.linkTo(sentTime.end)
                        top.linkTo(sentTime.bottom, margin = 5.dp)
                    }
            ) {
                MessageCount(homeChat.messageCount)
            }

            Divider(modifier = Modifier
                .fillMaxWidth()
                .constrainAs(bottomDivider) {
                    top.linkTo(
                        profilePicture.bottom
                    )
                }
                .padding(top = 15.dp))
        }
    }
}

@Composable
fun StatusIcon(status: Int) {
    val icon: ImageVector =
        when (status) {
            HomeChat.WAITING -> Icons.Rounded.Schedule
            HomeChat.SENT -> Icons.Rounded.Done
            HomeChat.DELIVERED -> Icons.Rounded.DoneAll
            HomeChat.SEEN -> Icons.Rounded.DoneAll
            else -> Icons.Rounded.Done
        }
    val tint: Color =
        when (status) {
            HomeChat.WAITING -> Gray50
            HomeChat.SEEN -> Blue40
            else -> Gray60
        }
    Icon(
        imageVector = icon,
        tint = tint,
        contentDescription = "delivered",
        modifier = Modifier
            .size(18.dp)
    )
}

@Composable
fun MessageCount(messageCount: Int) {
    Text(
        text = "$messageCount",
        fontSize = 15.sp,
        color = Color.White,
        modifier = Modifier
            .drawBehind {
                drawRoundRect(
                    color = Green50,
                    cornerRadius = CornerRadius(50F)
                )
            }
            .padding(start = 6.dp, end = 6.dp, bottom = 1.dp))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeItem() {
    LazyColumn {
        items(items = getRandomHomeChatList()) {
            HomeItem(it)
        }
    }
}
