package com.example.composethemestest.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentScreen(
    padding: PaddingValues
) {
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text(text = "MediumTopAppBar") },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description",
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Localized description",
                        )
                    }
                },
                scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),

            ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(68.dp)
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                onClick = {}
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Filled card",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Card(
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(68.dp)
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                onClick = {}
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Filled card disabled",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(68.dp)
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                onClick = {}
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Elevated card",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            ElevatedCard(
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(68.dp)
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                onClick = {}
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Elevated card disabled",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(68.dp)
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                onClick = {}
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Outlined card",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            OutlinedCard(
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(68.dp)
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                onClick = {}
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Outlined card disabled",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            ListItem(
                headlineContent = { Text("One line list item with 24x24 icon") },
                leadingContent = {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Localized description",
                    )
                },
                modifier = Modifier.clickable {  }
            )
            HorizontalDivider()

            ListItem(
                headlineContent = { Text("Two line list item with trailing") },
                supportingContent = { Text("Secondary text") },
                trailingContent = { Text("meta") },
                leadingContent = {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Localized description",
                    )
                },
                modifier = Modifier.clickable {  }
            )
            HorizontalDivider()

            ListItem(
                headlineContent = { Text("Three line list item") },
                overlineContent = { Text("OVERLINE") },
                supportingContent = { Text("Secondary text") },
                leadingContent = {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Localized description",
                    )
                },
                trailingContent = { Text("meta") },
                modifier = Modifier.clickable {  }
            )
            HorizontalDivider()

            ListItem(
                headlineContent = { Text("Three line list item") },
                supportingContent = {
                    Text("Secondary text that is long and perhaps goes onto another line")
                },
                leadingContent = {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Localized description",
                    )
                },
                trailingContent = { Text("meta") },
                modifier = Modifier.clickable {  }
            )
            HorizontalDivider()

            Spacer(Modifier.height(padding.calculateBottomPadding()))
        }
    }
}