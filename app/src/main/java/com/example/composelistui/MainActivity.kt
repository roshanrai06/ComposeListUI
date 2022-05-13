package com.example.composelistui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelistui.data.ScreenState
import com.example.composelistui.data.somePhotos
import com.example.composelistui.ui.PhotoCard
import com.example.composelistui.ui.PhotoDetailScreenFlattened
import com.example.composelistui.ui.TopBar
import com.example.composelistui.ui.theme.ComposeListUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeListUITheme {
                MainScreen()

            }
        }
    }
}

@Composable
fun MainScreen() {
    val screenState = remember { mutableStateOf<ScreenState>(ScreenState.LIST) }
    Scaffold(topBar = { TopBar() }) { padding ->
        when (val state = screenState.value) {
            is ScreenState.LIST -> PhotoList(padding = padding, onClick = { photoUrl ->
                screenState.value = ScreenState.Details(photoUrl)
            })
            is ScreenState.GRID -> PhotoGrid(padding = padding, onClick = { photoUrl ->
                screenState.value = ScreenState.Details(photoUrl)

            })
            is ScreenState.Details -> PhotoDetailScreenFlattened(photoUrl = state.photoUrl)
        }
    }
}

@Composable
fun PhotoGrid(padding: PaddingValues, onClick: (String) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(somePhotos()) { photoUrl ->
            PhotoCard(photoUrl, onClick = { onClick(photoUrl) })
        }
    }

}

@Composable
fun PhotoList(padding: PaddingValues, onClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .padding(padding)
    ) {
        items(somePhotos()) { photoUrl ->
            PhotoCard(photoUrl, onClick = { onClick(photoUrl) })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeListUITheme {
        MainScreen()
    }
}