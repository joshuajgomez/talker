package com.joshgm3z.talker.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.joshgm3z.talker.chat.ui.isInPreview
import com.joshgm3z.talker.home.HomeChat
import com.joshgm3z.talker.common.room.entity.User
import com.joshgm3z.talker.common.utils.getRandomHomeChatList

@Composable
fun HomeScreen(
    homeChatListLive: LiveData<List<HomeChat>> = MutableLiveData(),
    onChatClick: (user: User) -> Unit = {},
) {
    Column(modifier = Modifier.background(Color.White)) {
        HomeHeader()
        HomeChatList(homeChatListLive, onChatClick)
    }
}

@Composable
fun HomeHeader() {
    Row(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Title()
    }
}

@Composable
fun HomeChatList(
    homeChatListLive: LiveData<List<HomeChat>>,
    onChatClick: (user: User) -> Unit,
) {
    val homeChatList: List<HomeChat> =
        if (isInPreview()) getRandomHomeChatList()
        else homeChatListLive.observeAsState(listOf()).value
    LazyColumn {
        items(items = homeChatList) {
            HomeItem(homeChat = it, onChatClick = onChatClick)
        }
    }
}

@Composable
@Preview
fun PreviewHomeScreen() {
    HomeScreen()
}

