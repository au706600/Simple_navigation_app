package com.example.firstnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstnavigation.ui.theme.FirstnavigationTheme

data class menuitemmodel(val id: String,
                         val title: String,
                         val iconVector: ImageVector,
                         val contentDescription: String,
                         val onClick: () -> Unit)



@Composable
fun MenuItem(menuitem: menuitemmodel, navigate: () -> Unit)
{
    Row(
        Modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                menuitem.onClick()
                navigate() }) {
        Text(
            text = menuitem.title,
            Modifier.weight(1f),
            style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.onPrimary
        )
        Icon(
            imageVector = menuitem.iconVector,
            contentDescription = menuitem.contentDescription,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}


