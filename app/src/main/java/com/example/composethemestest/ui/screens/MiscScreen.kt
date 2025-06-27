package com.example.composethemestest.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MiscScreen(
    padding: PaddingValues,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "TopAppBar") },
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
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),

        ) {

            var tabState by remember { mutableIntStateOf(0) }
            val titles = listOf("Tab 1", "Tab 2", "Tab 3")
            PrimaryTabRow(selectedTabIndex = tabState) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        selected = tabState == index,
                        onClick = { tabState = index },
                        text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
                    )
                }
            }


            Column(Modifier.padding(horizontal = 16.dp)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    FilledTonalIconButton(onClick = {}) { Icon(imageVector = Icons.Rounded.DateRange, contentDescription = null) }
                    FilledTonalIconButton(onClick = {}, enabled = false) { Icon(imageVector = Icons.Rounded.DateRange, contentDescription = null) }
                    FilledIconButton(onClick = {}) { Icon(imageVector = Icons.Rounded.DateRange, contentDescription = null) }
                    FilledIconButton(onClick = {}, enabled = false) { Icon(imageVector = Icons.Rounded.DateRange, contentDescription = null) }
                    IconButton(onClick = {}) { Icon(imageVector = Icons.Rounded.AccountBox, contentDescription = null) }
                    IconButton(onClick = {}, enabled = false) { Icon(imageVector = Icons.Rounded.AccountBox, contentDescription = null) }
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    FilledTonalButton(onClick = {}) { Text("Filled tonal button") }
                    Spacer(Modifier.width(2.dp))
                    FilledTonalButton(onClick = {}, enabled = false) { Text("Filled tonal button") }
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    ElevatedButton(onClick = {}) { Text("Elevated button") }
                    Spacer(Modifier.width(2.dp))
                    ElevatedButton(onClick = {}, enabled = false) { Text("Elevated button") }
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedButton(onClick = {}) { Text("Outlined button") }
                    Spacer(Modifier.width(2.dp))
                    OutlinedButton(onClick = {}, enabled = false) { Text("Outlined button") }
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    TextButton(onClick = {}) { Text("Text button") }
                    Spacer(Modifier.width(2.dp))
                    TextButton(onClick = {}, enabled = false) { Text("Text button") }
                }
                SingleChoiceSegmentedButtonRow {
                    var selected by remember { mutableIntStateOf(0) }
                    SegmentedButton(
                        selected = selected == 0,
                        onClick = { selected = 0 },
                        shape = MaterialTheme.shapes.medium.copy(topEnd = CornerSize(0.dp), bottomEnd = CornerSize(0.dp)),
                    ) {
                        Text("Segmented 1")
                    }
                    SegmentedButton(
                        selected = selected == 1,
                        onClick = { selected = 1 },
                        shape = MaterialTheme.shapes.medium.copy(topStart = CornerSize(0.dp), bottomStart = CornerSize(0.dp)),
                    ) {
                        Text("Segmented 2")
                    }
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    FloatingActionButton(onClick = {}) {
                        Icon(imageVector = Icons.Rounded.AccountBox, contentDescription = null)
                    }
                    Spacer(Modifier.width(4.dp))

                    ExtendedFloatingActionButton(
                        text = { Text("Extended FAB") },
                        icon = { Icon(imageVector = Icons.Rounded.AccountBox, contentDescription = null) },
                        onClick = {},
                        expanded = true
                    )
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    AssistChip(
                        onClick = {  },
                        label = { Text("Assist chip") },
                        leadingIcon = {
                            Icon(
                                Icons.Filled.Settings,
                                contentDescription = "Localized description",
                                Modifier.size(AssistChipDefaults.IconSize)
                            )
                        }
                    )
                    Spacer(Modifier.width(2.dp))
                    AssistChip(
                        enabled = false,
                        onClick = {  },
                        label = { Text("Assist chip") },
                        leadingIcon = {
                            Icon(
                                Icons.Filled.Settings,
                                contentDescription = "Localized description",
                                Modifier.size(AssistChipDefaults.IconSize)
                            )
                        }
                    )
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    var selected by remember { mutableStateOf(false) }
                    FilterChip(
                        onClick = { selected = !selected },
                        label = {
                            Text("Filter chip")
                        },
                        selected = selected,
                        leadingIcon = if (selected) {
                            {
                                Icon(
                                    imageVector = Icons.Filled.Done,
                                    contentDescription = "Done icon",
                                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                                )
                            }
                        } else {
                            null
                        },
                    )
                    Spacer(Modifier.width(2.dp))
                    FilterChip(
                        enabled = false,
                        onClick = { selected = !selected },
                        label = {
                            Text("Filter chip")
                        },
                        selected = selected,
                        leadingIcon = if (selected) {
                            {
                                Icon(
                                    imageVector = Icons.Filled.Done,
                                    contentDescription = "Done icon",
                                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                                )
                            }
                        } else {
                            null
                        },
                    )
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    var enabled by remember { mutableStateOf(true) }
                    InputChip(
                        onClick = {
                            enabled = !enabled
                        },
                        label = { Text("Input chip") },
                        selected = enabled,
                        avatar = {
                            Icon(
                                Icons.Filled.Person,
                                contentDescription = "Localized description",
                                Modifier.size(InputChipDefaults.AvatarSize)
                            )
                        },
                        trailingIcon = {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "Localized description",
                                Modifier.size(InputChipDefaults.AvatarSize)
                            )
                        },
                    )
                    Spacer(Modifier.width(2.dp))
                    InputChip(
                        enabled = false,
                        onClick = {
                            enabled = !enabled
                        },
                        label = { Text("Input chip") },
                        selected = enabled,
                        avatar = {
                            Icon(
                                Icons.Filled.Person,
                                contentDescription = "Localized description",
                                Modifier.size(InputChipDefaults.AvatarSize)
                            )
                        },
                        trailingIcon = {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "Localized description",
                                Modifier.size(InputChipDefaults.AvatarSize)
                            )
                        },
                    )
                }

                // We have two radio buttons and only one can be selected
                var state by remember { mutableStateOf(true) }
// Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior.
// We also set a content description for this sample, but note that a RadioButton would usually
// be part of a higher level component, such as a raw with text, and that component would need
// to provide an appropriate content description. See RadioGroupSample.
                Row(Modifier.selectableGroup()) {
                    RadioButton(
                        selected = state,
                        onClick = { state = true },
                        modifier = Modifier.semantics { contentDescription = "Localized Description" }
                    )
                    RadioButton(
                        selected = !state,
                        onClick = { state = false },
                        modifier = Modifier.semantics { contentDescription = "Localized Description" }
                    )
                    RadioButton(
                        enabled = false,
                        selected = !state,
                        onClick = { state = false },
                        modifier = Modifier.semantics { contentDescription = "Localized Description" }
                    )
                    Spacer(Modifier.width(2.dp))

                    var switch by remember { mutableStateOf(true) }
                    Switch(
                        checked = switch,
                        onCheckedChange = {
                            switch = it
                        }
                    )
                    Spacer(Modifier.width(2.dp))
                    Switch(
                        enabled = false,
                        checked = switch,
                        onCheckedChange = {
                            switch = it
                        }
                    )

                    Spacer(Modifier.width(2.dp))
                    var checked by remember { mutableStateOf(true) }
                    Checkbox(checked = checked, onCheckedChange = { checked = !checked })
                    Checkbox(checked = checked, enabled = false, onCheckedChange = {})
                }


                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    var sliderPosition1 by remember { mutableFloatStateOf(0.4f) }
                    Slider(
                        value = sliderPosition1,
                        onValueChange = { sliderPosition1 = it }
                    )
                    Slider(
                        enabled = false,
                        value = sliderPosition1,
                        onValueChange = { sliderPosition1 = it }
                    )

                    var sliderPosition2 by remember { mutableFloatStateOf(16f) }
                    Slider(
                        value = sliderPosition2,
                        onValueChange = { sliderPosition2 = it },
                        steps = 3,
                        valueRange = 0f..50f
                    )
                    Slider(
                        enabled = false,
                        value = sliderPosition2,
                        onValueChange = { sliderPosition2 = it },
                        steps = 3,
                        valueRange = 0f..50f
                    )

                    var sliderRangePosition by remember { mutableStateOf(0f..100f) }
                    RangeSlider(
                        value = sliderRangePosition,
                        steps = 5,
                        onValueChange = { range -> sliderRangePosition = range },
                        valueRange = 0f..100f,
                        onValueChangeFinished = {
                            // launch some business logic update with the state you hold
                            // viewModel.updateSelectedSliderValue(sliderPosition)
                        },
                    )
                    RangeSlider(
                        enabled = false,
                        value = sliderRangePosition,
                        steps = 5,
                        onValueChange = { range -> sliderRangePosition = range },
                        valueRange = 0f..100f,
                        onValueChangeFinished = {
                            // launch some business logic update with the state you hold
                            // viewModel.updateSelectedSliderValue(sliderPosition)
                        },
                    )
                }
            }

            Spacer(Modifier.height(4.dp))
            LinearProgressIndicator(Modifier.fillMaxWidth())
            Spacer(Modifier.height(4.dp))
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth(), progress = { 0.4f })
            Spacer(Modifier.height(4.dp))

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                CircularProgressIndicator()
                Spacer(Modifier.width(4.dp))
                CircularProgressIndicator(progress = { 0.4f })
            }

            Spacer(modifier = Modifier.height(padding.calculateBottomPadding()))
        }
    }
}