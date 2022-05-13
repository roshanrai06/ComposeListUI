package com.example.composelistui.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PhotoCard(photoUrl: String, onClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable(onClick = {onClick(photoUrl)})
    ) {
        Column {
            PhotoHeader("Sample Title", "Sample SubTitle")
            AsyncImage(
                model = photoUrl,
                contentScale = ContentScale.Crop,
                contentDescription = "Images ",
                modifier = Modifier
                    .fillMaxSize()
                    .height(220.dp)
            )
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Some random text descriptions 1 " +
                        "Some random text descriptions  " +
                        "Some random text descriptions " +
                        " Some random text descriptions ",
                style = MaterialTheme.typography.body1,
                color = Color.DarkGray
            )
            Row(modifier = Modifier.padding(8.dp)) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Action 1")

                }
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Action 1")
                }
                Spacer(modifier = Modifier.weight(1f))

                IconBtn(modifier = Modifier, onClick = { }, Icons.Default.Favorite)
                IconBtn(modifier = Modifier, onClick = { }, Icons.Default.Share)
            }

        }

    }
}