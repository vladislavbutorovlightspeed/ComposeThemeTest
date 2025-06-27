package com.example.composethemestest.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogsScreen(
    padding: PaddingValues
) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        modifier = Modifier.padding(bottom = padding.calculateBottomPadding()),
        topBar = {
            LargeTopAppBar(
                title = { Text(text = "LargeTopAppBar") },
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
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxHeight(),

            ) {

            DatePickerDocked()

            var isDropdownShown by remember { mutableStateOf(false) }
            FilledTonalButton(
                onClick = { isDropdownShown = true }
            ) {
                Text("DropdownMenu")
            }
            if (isDropdownShown) {
                DropdownMenu(
                    modifier = Modifier,
                    onDismissRequest = { isDropdownShown = false },
                    expanded = true
                ) {
                    DropdownMenuItem(
                        modifier = Modifier,
                        text = { Text(text = "Item 1") },
                        onClick = {}
                    )
                    DropdownMenuItem(

                        modifier = Modifier,
                        text = { Text(text = "Item 2") },
                        onClick = {}
                    )
                    DropdownMenuItem(
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = null
                            )
                        },
                        modifier = Modifier,
                        text = { Text(text = "Item 3") },
                        onClick = {}
                    )
                    DropdownMenuItem(
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = null
                            )
                        },
                        modifier = Modifier,
                        text = { Text(text = "Item 4") },
                        onClick = {}
                    )
                    HorizontalDivider()
                    DropdownMenuItem(
                        enabled = false,
                        modifier = Modifier,
                        text = { Text(text = "Item 5") },
                        onClick = {}
                    )
                }
            }

            var isAlertShown by remember { mutableStateOf(false) }
            FilledTonalButton(
                onClick = { isAlertShown = true }
            ) {
                Text("AlertDialog")
            }
            if (isAlertShown) {
                AlertDialog(
                    icon = { Icon(Icons.Filled.Face, contentDescription = "Example Icon") },
                    title = { Text(text = "Title") },
                    text = { Text(text = "Text (text text text text text text text text)") },
                    onDismissRequest = { isAlertShown = false },
                    confirmButton = {
                        TextButton(onClick = {
                            isAlertShown = false
                        }) { Text("Confirm") }
                    },
                    dismissButton = {
                        TextButton(onClick = {
                            isAlertShown = false
                        }) { Text("Dismiss") }
                    }
                )
            }

            val datePickerState = rememberDatePickerState()
            var isDatePicker by remember { mutableStateOf(false) }
            FilledTonalButton(
                onClick = { isDatePicker = true }
            ) {
                Text("DatePickerDialog")
            }
            if (isDatePicker) {
                DatePickerDialog(
                    onDismissRequest = { isDatePicker = false },
                    confirmButton = {
                        TextButton(onClick = {
                            isDatePicker = false
                        }) { Text("Confirm") }
                    },
                    dismissButton = {
                        TextButton(onClick = {
                            isDatePicker = false
                        }) { Text("Dismiss") }
                    }
                ) {
                    DatePicker(state = datePickerState)
                }
            }

            val currentTime = Calendar.getInstance()
            var isTimePicker by remember { mutableStateOf(false) }
            val timePickerState = rememberTimePickerState(
                initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
                initialMinute = currentTime.get(Calendar.MINUTE),
                is24Hour = false,
            )
            FilledTonalButton(
                onClick = { isTimePicker = true }
            ) {
                Text("TimePickerDialog")
            }
            if (isTimePicker) {
                DatePickerDialog(
                    onDismissRequest = { isTimePicker = false },
                    confirmButton = {
                        TextButton(onClick = {
                            isTimePicker = false
                        }) { Text("Confirm") }
                    },
                    dismissButton = {
                        TextButton(onClick = {
                            isTimePicker = false
                        }) { Text("Dismiss") }
                    }
                ) {
                    Box(Modifier.padding(16.dp).align(Alignment.CenterHorizontally)) {
                        TimePicker(state = timePickerState)
                    }
                }
            }


            val sheetState = rememberModalBottomSheetState()
            val scope = rememberCoroutineScope()
            var showBottomSheet by remember { mutableStateOf(false) }
            FilledTonalButton(
                onClick = { showBottomSheet = true }
            ) {
                Text("ModalBottomSheet")
            }
            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState
                ) {
                    // Sheet content
                    Spacer(Modifier.height(128.dp))
                    Button(
                        modifier = Modifier.padding(16.dp),
                        onClick = {
                            scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showBottomSheet = false
                                }
                            }
                        }) {
                        Text("Hide bottom sheet")
                    }
                    Spacer(Modifier.height(16.dp))
                }
            }

            FilledTonalButton(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = "Snackbar with some information",
                            actionLabel = "Action"
                        )
                    }
                }
            ) {
                Text("Snackbar")
            }

        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDocked() {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selectedDate,
            onValueChange = { },
            label = { Text("DOB") },
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { showDatePicker = !showDatePicker }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select date"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        )

        if (showDatePicker) {
            Popup(
                onDismissRequest = { showDatePicker = false },
                alignment = Alignment.TopStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.9f)
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(16.dp))
                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false
                    )
                }
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DatePickerFieldToModal(modifier: Modifier = Modifier) {
//    var selectedDate by remember { mutableStateOf<Long?>(null) }
//    var showModal by remember { mutableStateOf(false) }
//
//    OutlinedTextField(
//        value = selectedDate?.let { convertMillisToDate(it) } ?: "",
//        onValueChange = { },
//        label = { Text("DOB") },
//        placeholder = { Text("MM/DD/YYYY") },
//        trailingIcon = {
//            Icon(Icons.Default.DateRange, contentDescription = "Select date")
//        },
//        modifier = modifier
//            .fillMaxWidth()
//            .pointerInput(selectedDate) {
//                awaitEachGesture {
//                    // Modifier.clickable doesn't work for text fields, so we use Modifier.pointerInput
//                    // in the Initial pass to observe events before the text field consumes them
//                    // in the Main pass.
//                    awaitFirstDown(pass = PointerEventPass.Initial)
//                    val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
//                    if (upEvent != null) {
//                        showModal = true
//                    }
//                }
//            }
//    )
//
//    if (showModal) {
//        DatePickerDialog(
//            onDismissRequest = {  },
//            confirmButton = {
//                TextButton(onClick = {
//                    isDatePicker = false
//                }) { Text("Confirm") }
//            },
//            dismissButton = {
//                TextButton(onClick = {
//                    isDatePicker = false
//                }) { Text("Dismiss") }
//            }
//        ) {
//            DatePicker(state = datePickerState)
//        }
//    }
//}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}