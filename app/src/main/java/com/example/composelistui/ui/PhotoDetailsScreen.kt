package com.example.composelistui.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.composelistui.R

@Composable
fun PhotoDetailScreen(photoUrl: String) {
    Column(
        Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        PhotoHeader("Sample Title", "Sample SubTitle")
        AsyncImage(
            model = photoUrl,
            contentScale = ContentScale.Crop,
            contentDescription = "Images ",
            modifier = Modifier
                .fillMaxSize()
                .height(220.dp)
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
        Divider(Modifier.padding(16.dp))

        Text(
            modifier = Modifier.padding(16.dp),
            text = stringResource(id = R.string.lorem_ipsum),
            style = MaterialTheme.typography.body1,
            color = Color.DarkGray
        )

    }

}
@Preview(showBackground = true)
@Composable fun ComposeDetailsUI(){
    PhotoDetailScreen("djfhdj idhfidhfih")
}

