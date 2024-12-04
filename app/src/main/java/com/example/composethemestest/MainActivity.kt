package com.example.composethemestest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composethemestest.ui.screens.ContentScreen
import com.example.composethemestest.ui.screens.DialogsScreen
import com.example.composethemestest.ui.screens.TextsScreen
import com.example.composethemestest.ui.screens.MiscScreen
import com.example.composethemestest.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                var selectedIndex by remember { mutableIntStateOf(0) }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = selectedIndex == 0,
                                onClick = { selectedIndex = 0 },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Rounded.Build,
                                        contentDescription = null,
                                    )
                                },
                                label = { Text("Miscellaneous") },
                            )
                            NavigationBarItem(
                                selected = selectedIndex == 1,
                                onClick = { selectedIndex = 1 },
                                icon = {
                                    BadgedBox(
                                        badge = { Badge() }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Rounded.Build,
                                            contentDescription = null,
                                        )
                                    }
                                },
                                label = { Text("Content") },
                            )
                            NavigationBarItem(
                                selected = selectedIndex == 2,
                                onClick = { selectedIndex = 2 },
                                icon = {
                                    BadgedBox(
                                        badge = { Badge { Text("1") } }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Rounded.Build,
                                            contentDescription = null,
                                        )
                                    }
                                },
                                label = { Text("Dialogs") },
                            )
                            NavigationBarItem(
                                selected = selectedIndex == 3,
                                onClick = { selectedIndex = 3 },
                                icon = {
                                    BadgedBox(
                                        badge = { Badge { Text("100") } }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Rounded.Build,
                                            contentDescription = null,
                                        )
                                    }
                                },
                                label = { Text("Texts") },
                            )
                        }
                    }
                ) { innerPadding ->
                    Column {
                        when (selectedIndex) {
                            0 -> MiscScreen(innerPadding)
                            1 -> ContentScreen(innerPadding)
                            2 -> DialogsScreen(innerPadding)
                            3 -> TextsScreen(innerPadding)
                            else -> MiscScreen(innerPadding)
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Greeting("Android")
    }
}