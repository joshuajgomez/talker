package com.joshgm3z.talker.users

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBox() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(80.dp)
            .padding(start = 5.dp, end = 10.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "go back",
            modifier = Modifier
                .size(40.dp)
                .padding(all = 5.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        var input by remember { mutableStateOf("") }
        TextField(
            value = "Someone",
            onValueChange = { input = it },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            placeholder = {
                Text(text = "Type a name")
            }
        )
        Spacer(modifier = Modifier.width(5.dp))
        Icon(
            imageVector = Icons.Rounded.Close,
            contentDescription = "clear input",
            modifier = Modifier
                .size(40.dp)
                .padding(all = 5.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSearchBox() {
    Column(modifier = Modifier.fillMaxSize()) {
        SearchBox()
        Surface(modifier = Modifier
            .fillMaxHeight()
            .weight(1f)){}
    }
}