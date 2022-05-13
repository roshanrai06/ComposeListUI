package com.example.composelistui.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composelistui.R

@Composable
fun TopBar() {
    val showMenu = remember { mutableStateOf(false) }
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        actions = {

            IconButton(
                onClick = { showMenu.value = !showMenu.value }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Dropdown Menu"
                )
            }
            DropdownMenu(
                expanded = showMenu.value,
                onDismissRequest = { showMenu.value = false }
            ) {
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Text(text = "Setting", modifier = Modifier.padding(horizontal = 8.dp))

                }
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Text(text = "Contact Support", modifier = Modifier.padding(horizontal = 8.dp))

                }

            }
        }
    )


}