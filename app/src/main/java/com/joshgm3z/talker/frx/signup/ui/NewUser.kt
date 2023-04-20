package com.joshgm3z.talker.frx.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.joshgm3z.talker.R
import com.joshgm3z.talker.common.ui.SimpleTitleBar

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun NewUser(
    onOpenGalleryClick: () -> Unit = {},
    onOpenCameraClick: () -> Unit = {},
    onSignupClick: () -> Unit = {},
) {
    Column(modifier = Modifier.fillMaxSize()) {

        SimpleTitleBar(title = "New user")

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (
                profilePic,
                uploadPicture,
                takePhoto,
                nameTitle,
                nameInput,
                nameStatus,
                btnSubmit,
            ) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.sample_user),
                contentDescription = "profile picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp)
                    .constrainAs(profilePic) {
                        top.linkTo(parent.top, margin = 60.dp)
                        start.linkTo(parent.start, 40.dp)
                    }
            )

            Button(
                onClick = { onOpenGalleryClick() },
                modifier = Modifier
                    .constrainAs(uploadPicture) {
                        top.linkTo(profilePic.top)
                        start.linkTo(profilePic.end, margin = 20.dp)
                    },
            ) {
                Text(text = "Open gallery")
            }

            Button(
                onClick = { onOpenCameraClick() },
                modifier = Modifier
                    .constrainAs(takePhoto) {
                        top.linkTo(uploadPicture.bottom, margin = 10.dp)
                        start.linkTo(uploadPicture.start)
                    },
            ) {
                Text(text = "Take photo")
            }

            Text(
                text = "Choose username:",
                fontSize = 20.sp,
                modifier = Modifier.constrainAs(nameTitle) {
                    top.linkTo(profilePic.bottom, margin = 70.dp)
                    start.linkTo(profilePic.start)
                })

            var name by remember { mutableStateOf("") }
            TextField(
                value = name,
                onValueChange = { name = it },
                placeholder = {
                    Text(text = "Eg: smiling_dragon")
                },
                modifier = Modifier.constrainAs(nameInput) {
                    top.linkTo(nameTitle.bottom, margin = 10.dp)
                    start.linkTo(nameTitle.start)
                })

            Surface(modifier = Modifier.constrainAs(nameStatus) {
                top.linkTo(nameInput.bottom, margin = 10.dp)
                start.linkTo(nameInput.start)
            }) {
                StatusMessage()
            }

            Button(
                onClick = { onSignupClick() },
                modifier = Modifier.constrainAs(btnSubmit) {
                    end.linkTo(parent.end, margin = 20.dp)
                    bottom.linkTo(parent.bottom, margin = 20.dp)
                },
            ) {
                Text(text = "Sign up")
            }
        }
    }
}

@Composable
fun StatusMessage() {
    Row {
        Text(
            text = "Username already exists. Choose another one",
        )
    }
}

