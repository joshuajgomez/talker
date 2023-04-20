package com.joshgm3z.talker.users

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.joshgm3z.talker.R
import com.joshgm3z.talker.common.room.entity.User
import com.joshgm3z.talker.common.utils.getRandomUser
import com.joshgm3z.talker.common.utils.getRandomUserList

@Composable
fun UserItem(user: User) {
    ConstraintLayout(
        modifier = Modifier.padding(
            start = 10.dp,
            end = 10.dp,
        )
    ) {
        val (picture, name, divider) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.sample_user),
            contentDescription = "profile picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
                .constrainAs(picture) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
        )

        Text(
            text = user.name,
            maxLines = 1,
            fontSize = 18.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .constrainAs(name) {
                    top.linkTo(picture.top)
                    bottom.linkTo(picture.bottom)
                    start.linkTo(picture.end, margin = 10.dp)
                }
                .fillMaxWidth(0.8f)
        )

        Divider(modifier = Modifier.constrainAs(divider) {
            top.linkTo(picture.bottom, margin = 10.dp)
            start.linkTo(parent.start)
        })

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewUserItem() {
    LazyColumn() {
        items(items = getRandomUserList()) {
            UserItem(it)
        }
    }
}