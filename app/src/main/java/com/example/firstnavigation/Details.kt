package com.example.firstnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun Details(getFriend: () -> Repository.FriendDetail, navigate: () -> Unit) {
    val friend = remember { mutableStateOf<Repository.FriendDetail?>(null) }

    LaunchedEffect(Unit) {
        friend.value = getFriend()
    }
    Column {

        IconButton(onClick = {navigate()}) {
            Icon(Icons.Default.ArrowBack, contentDescription = "back")
        }

        friend.value?.let {
            FriendDetailWidget(friend = it)
        }

    }
}