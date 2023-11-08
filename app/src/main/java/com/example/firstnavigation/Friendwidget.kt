package com.example.firstnavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun FriendWidget(friend: Repository.FriendId, handleClick: (id: String) -> Unit, imageId: Int) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable { handleClick(friend.id) }) {
        Row(modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
            .padding(5.dp)) {

            Image(painter = painterResource(id = imageId),
                contentDescription = "Image",
                modifier = Modifier.width(100.dp))

            Text(modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
                .padding(5.dp),
                text = "Name is: ${friend.name}",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimary)
        }
    }

}