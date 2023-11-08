package com.example.firstnavigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController

@Composable

fun schooldetails(getElementarySchool: () -> Repository.School?, navigate:() -> Unit)
{
    val SChool = remember { mutableStateOf<Repository.School?>(null) }

    LaunchedEffect(Unit) {
        SChool.value = getElementarySchool()
    }
    Column {
        IconButton(onClick = {navigate()}) {
            Icon(Icons.Default.ArrowBack, contentDescription = "back")
        }

        SChool.value?.let {
            schooldetail(SChool = it, navigate)
        }

    }
}