package com.joshgm3z.talker.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
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
    onSearchIconClick: () -> Unit = {},
) {
    Column(modifier = Modifier.background(Color.White)) {
        HomeHeader(onSearchIconClick)
        HomeChatList(homeChatListLive, onChatClick)
    }
}

@Composable
fun HomeHeader(onSearchIconClick: () -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth(),
    ) {
        val (title, searchIcon) = createRefs()
        Surface(
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }
        ) {
            Title()
        }
        Icon(
            imageVector = Icons.Rounded.Search,
            contentDescription = "search",
            modifier = Modifier
                .constrainAs(searchIcon) {
                    end.linkTo(parent.end, margin = 10.dp)
                    top.linkTo(title.top)
                    bottom.linkTo(title.bottom)
                }
                .size(40.dp)
                .padding(all = 5.dp)
                .clickable { onSearchIconClick() }
        )
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

