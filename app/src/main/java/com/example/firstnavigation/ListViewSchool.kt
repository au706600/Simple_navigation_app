package com.example.firstnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
fun listviewSchool(
    fetchList: () -> List<Repository.School>,
    back: () -> Unit,
    navigate: (id: String) -> Unit
)
{
    val listschool = remember { mutableStateOf<List<Repository.School>>(emptyList()) }
    LaunchedEffect(Unit) {
        listschool.value = fetchList()
    }

    Column {
        IconButton(onClick = { back() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "back")
        }

        LazyColumn {
            items(listschool.value) {
                schoolwidget(school = it, navigate)
            }
        }
    }
}
