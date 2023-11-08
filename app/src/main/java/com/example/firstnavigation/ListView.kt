package com.example.firstnavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ListView(
    fetchList: () -> List<Repository.FriendId>,
    back: () -> Unit,
    navigate: (friendId: String) -> Unit,
    imageId:Int
) {
    val list = remember { mutableStateOf<List<Repository.FriendId>>(emptyList()) }
    LaunchedEffect(Unit) {
        list.value = fetchList()
    }
    Column {
        IconButton(onClick = {back()})
        {
            Icon(Icons.Default.ArrowBack, contentDescription = "back")
        }

        LazyColumn {

            items(list.value) {
                FriendWidget(friend = it, navigate, R.drawable.jamesbond)
            }
        }
    }
}