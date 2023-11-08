package com.example.firstnavigation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstnavigation.ui.theme.FirstnavigationTheme

const val TAG_APP_BAR = "MyAppBar"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(title:String, onMenu: () -> Unit)
{

    TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = Color.DarkGray,
        titleContentColor = Color(0xFFD0BCFF)),
        title = {Text(title)},
        navigationIcon = {
            IconButton(onClick = {
                Log.v(TAG_APP_BAR, "ONCLICK")
                onMenu()
            }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Drawer",
                    tint = Color(0xFFD0BCFF)
                )
            }
        }
    )

}


@Preview(showBackground = true)
@Composable
fun MyAppBarPreview() {
    FirstnavigationTheme(darkTheme = true) {
        MyAppBar(title = "TestTitle") {
            Log.v("AppBar", "menuClicked")
        }
    }
}