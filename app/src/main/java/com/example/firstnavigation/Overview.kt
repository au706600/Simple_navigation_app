package com.example.firstnavigation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.firstnavigation.ui.theme.FirstnavigationTheme

@Composable
fun Overview(
    title: String,
    menuitems: List<menuitemmodel>,
    onMenuItemClick: (menuitemmodel) -> Unit,
    back: () -> Unit
) {
    Column {
        IconButton(onClick = { back() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
        LazyColumn(Modifier.background(MaterialTheme.colorScheme.background)) {
            item {
                DrawerHeader(title = title)
            }

            items(menuitems) { item ->
                MenuItem(menuitem = item) {
                    onMenuItemClick(item)
                }
            }
        }
    }
}
