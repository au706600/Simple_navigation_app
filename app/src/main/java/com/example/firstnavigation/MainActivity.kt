package com.example.firstnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstnavigation.ui.theme.FirstnavigationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstnavigationTheme {
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                val menuItems = listOf(
                    menuitemmodel("1","Friends", Icons.Default.Home,"Vacations") {
                        println("Clicked")
                    },
                    menuitemmodel("2","My road to University", Icons.Default.Settings,"Countries") {
                        println("Clicked")
                    },
                    menuitemmodel("3", "Profile", Icons.Filled.Check, "Profile")
                    {
                        println("Clicked")
                    },
                )


                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Drawer("My book", menuItems)
                        }
                    },
                    content = {
                        Column {
                            val repository = Repository()
                            val Schools = repository.getElementarySchoolList()

                            NavHost(navController = navController, startDestination = "myappbar") {
                                composable("myappbar")
                                {
                                    MyAppBar(title = "Menu") {
                                        navController.navigate("overView")
                                    }
                                    Image(
                                        painter = painterResource(id = R.drawable.earth),
                                        contentDescription = "earth",
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }

                                composable("overView") {
                                    Overview(
                                        title = "My book",
                                        menuitems = menuItems,
                                        onMenuItemClick = { selectedItem ->
                                            when (selectedItem.id) {
                                                "1" -> {

                                                    navController.navigate("listView")
                                                }
                                                "2" -> {
                                                    navController.navigate("ListViewschool")
                                                }
                                                "3" -> {

                                                    navController.navigate("profilescreen")

                                                }
                                            }
                                        },
                                        back = { navController.navigate("myappbar") }
                                    )
                                }

                                composable("listView") {
                                    ListView(
                                        fetchList = { repository.getList() },
                                        back = { navController.popBackStack("overView", inclusive = false) },
                                        navigate = { friendId -> navController.navigate("details/$friendId") },
                                        imageId = R.drawable.jamesbond
                                    )
                                }

                                composable("ListViewschool")
                                {
                                    listviewSchool(
                                        fetchList = {Schools},
                                        back = {navController.popBackStack("overView", inclusive = false)},
                                        navigate = {id -> navController.navigate("SchoolDetails/$id")}
                                    )
                                }

                                composable("SchoolDetails/{id}")
                                {
                                    val id = it.arguments?.getString("id")
                                    schooldetails(getElementarySchool = {repository.getSchool(id)}) {
                                        navController.popBackStack("ListViewschool", inclusive = false)
                                    }
                                }

                                composable("details/{friendId}") {
                                    val friendId = it.arguments?.getString("friendId")
                                    Details(getFriend = { repository.getFriend(friendId) }) {
                                        navController.popBackStack("listView", inclusive = false)
                                    }
                                }

                                composable("profilescreen")
                                {
                                    ProfileScreen {
                                        navController.popBackStack("overView", inclusive = false)
                                    }
                                }

                            }
                        }
                    }
                )
            }
        }
    }
}
