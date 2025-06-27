package com.example.composethemestest.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextsScreen(
    padding: PaddingValues
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "CenterAlignedTopAppBar") },
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
                scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState()),

            ) {

//            val state = rememberTextFieldState("Initial text", TextRange(0, 12))
            var value by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Hint") },
                value = value,
                onValueChange = { value = it },
                singleLine = true,
                label = { Text("Label") },
            )
            Spacer(Modifier.height(4.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Hint") },
                value = value,
                onValueChange = { value = it },
                singleLine = true,
                label = { Text("Label") },
                enabled = false,
            )
            Spacer(Modifier.height(4.dp))

            var isError by rememberSaveable { mutableStateOf(false) }
            TextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Hint") },
                value = value,
                onValueChange = { value = it; isError = it.length > 10 },
                singleLine = true,
                label = { Text("Label") },
                leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                trailingIcon = {
                    IconButton(onClick = { value = "" }) {
                        Icon(Icons.Filled.Clear, contentDescription = "Clear text")
                    }
                },
                supportingText = {
                    Row {
                        Text(if (isError) "Error" else "", Modifier.clearAndSetSemantics {})
                        Spacer(Modifier.weight(1f))
                        Text("Limit: ${value.length}/10")
                    }
                },
//                onKeyboardAction = { isError = value.length > 10 },
                isError = isError,
            )

            Spacer(Modifier.height(4.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Hint") },
                value = value,
                onValueChange = { value = it },
                singleLine = true,
                label = { Text("Label") },
            )
            Spacer(Modifier.height(4.dp))
            OutlinedTextField(
                enabled = false,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Hint") },
                value = value,
                onValueChange = { value = it },
                singleLine = true,
                label = { Text("Label") },
            )
            Spacer(Modifier.height(4.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Hint") },
                value = value,
                onValueChange = { value = it; isError = it.length > 10 },
                singleLine = true,
                label = { Text("Label") },
                leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                trailingIcon = {
                    IconButton(onClick = { value = "" }) {
                        Icon(Icons.Filled.Clear, contentDescription = "Clear text")
                    }
                },
                supportingText = {
                    Row {
                        Text(if (isError) "Error" else "", Modifier.clearAndSetSemantics {})
                        Spacer(Modifier.weight(1f))
                        Text("Limit: ${value.length}/10")
                    }
                },
//                onKeyboardAction = { isError = value.length > 10 },
                isError = isError,
            )

            mapOf(
                MaterialTheme.typography.displayLarge to "displayLarge",
                MaterialTheme.typography.displayMedium to "displayMedium",
                MaterialTheme.typography.displaySmall to "displaySmall",
                MaterialTheme.typography.headlineLarge to "headlineLarge",
                MaterialTheme.typography.headlineMedium to "headlineMedium",
                MaterialTheme.typography.headlineSmall to "headlineSmall",
                MaterialTheme.typography.titleLarge to "titleLarge",
                MaterialTheme.typography.titleMedium to "titleMedium",
                MaterialTheme.typography.titleSmall to "titleSmall",
                MaterialTheme.typography.bodyLarge to "bodyLarge",
                MaterialTheme.typography.bodyMedium to "bodyMedium",
                MaterialTheme.typography.bodySmall to "bodySmall",
                MaterialTheme.typography.labelLarge to "labelLarge",
                MaterialTheme.typography.labelMedium to "labelMedium",
                MaterialTheme.typography.labelSmall to "labelSmall",
            ).forEach { (style, name) ->
                Text(name, style = style)
                Spacer(modifier = Modifier.height(8.dp))
            }


            Spacer(Modifier.height(padding.calculateBottomPadding()))

        }
    }
}