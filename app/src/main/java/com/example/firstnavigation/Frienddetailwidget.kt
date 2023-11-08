package com.example.firstnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun FriendDetailWidget(friend: Repository.FriendDetail) {
    Column {
        Text("Friend Name:  ${friend.friendId.name}")
        Text("Friend Age:  ${friend.age}")
        Text("Friend Mobile:  ${friend.mobile}")
    }
}