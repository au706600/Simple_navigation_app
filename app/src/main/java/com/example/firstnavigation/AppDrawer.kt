package com.example.firstnavigation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstnavigation.ui.theme.FirstnavigationTheme

@Composable
fun Drawer(title: String, menuitems: List<menuitemmodel>)
{
    Column {
        DrawerHeader(title = title)
        DrawerContent(menuitems = menuitems)
    }
}


@Composable
fun DrawerHeader(title: String)
{
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .padding(44.dp), contentAlignment = Alignment.Center

    ) {
        Text(title, color = MaterialTheme.colorScheme.onBackground, style = MaterialTheme.typography.headlineSmall)
    }
}


@Composable
fun DrawerContent(menuitems: List<menuitemmodel>) {

    Column {
        menuitems.forEach { menuItem ->
            Text(
                text = menuItem.title,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        menuItem.onClick()
                    }
            )
        }
    }
}


@Preview
@Composable
fun DrawerPreview() {
    val menuItems = listOf(
        menuitemmodel("1", "Home", Icons.Default.Home, "Home") {
            Log.v("DrawerPreview", "click home")
        },
        menuitemmodel("2", "Settings", Icons.Default.Settings, "Settings") {
            Log.v("DrawerPreview", "click settings")
        },
        menuitemmodel("3", "Profile", Icons.Filled.Check, "Profile")
        {
            println("Clicked")
        }
    )
    FirstnavigationTheme(darkTheme = true) {
        Drawer(
            "My book", menuItems
        )
    }
}

