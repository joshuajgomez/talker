package com.joshgm3z.talker.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joshgm3z.talker.chat.ui.theme.Gray40

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun SimpleTitleBar(
    title: String = "Simple title",
    onBackIconClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .background(Gray40)
            .fillMaxWidth()
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .fillMaxHeight()
                .width(80.dp)
                .clickable { onBackIconClick() }
                .padding(all = 18.dp),
        ) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "go back",
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
            )
        }
        Spacer(modifier = Modifier.width(3.dp))
        Text(
            text = title,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}