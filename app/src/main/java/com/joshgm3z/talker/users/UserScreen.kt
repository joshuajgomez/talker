package com.joshgm3z.talker.users

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.joshgm3z.talker.common.room.entity.User
import com.joshgm3z.talker.common.utils.getRandomUserList

@Composable
fun UserScreen(userList: List<User> = getRandomUserList()) {
    Column {
        SearchBox()
        UserList(userList)
    }
}

@Composable
fun UserList(userList: List<User>) {
    LazyColumn {
        items(items = userList) {
            UserItem(user = it)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewUserScreen() {
    UserScreen()
}