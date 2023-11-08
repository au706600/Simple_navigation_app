package com.example.firstnavigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun ProfileScreen(back: () -> Unit) {

    Column(modifier = Modifier.fillMaxWidth())
    {
        IconButton(onClick = { back() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }

        Image(
            painter = painterResource(id = R.drawable.profilepicture),
            contentDescription = "Profile picture",
            modifier = Modifier.width(200.dp).size(150.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Name: James Reddington",
            fontSize = 20.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Mail: Mr2018.dk@gmail.com",
            fontSize = 20.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Student ID: AU706600",
            fontSize = 20.sp,
            color = Color.Black
        )

    }
}