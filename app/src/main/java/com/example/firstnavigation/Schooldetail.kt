package com.example.firstnavigation

import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// I wanted to split the information such that if elementary school are clicked, the
// information about the elementary school are shown. Same goes for if high school item are clicked.
@Composable
fun schooldetail(SChool: Repository.School, back:() -> Unit) {
    Box(modifier = Modifier.border(width = 4.dp, color = Color.Blue))
    {
        Column()
        {

            Text(
                "As start to my journey, I went to elementary school for 10 years. During those years, " +
                        "I went to three different schools, Nordre Skole, Finderuphøj Skole and Vestre Skole in ${SChool.city.name} " +
                        "from 2008 to 2018."
            )
        }

    }

    Box(modifier = Modifier.border(width = 4.dp, color = Color.Blue))
    {
        Column()
        {

            Text(
                "After I finished elementary school, I went straight to high school that goes by " +
                        "the name VGHF in ${SChool.city.name} from 2018 and finished june 2021"
            )
        }

    }
}