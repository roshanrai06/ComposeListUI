package com.example.composelistui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PhotoHeader(title: String, subTitle: String) {
    Row(modifier = Modifier.padding(16.dp)) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Outlined.Face, contentDescription = "", tint = Color.DarkGray)
        }
        Column(Modifier.padding(start = 16.dp)) {
            Text(text = title, style = MaterialTheme.typography.h6)
            Text(
                text = subTitle,
                style = MaterialTheme.typography.subtitle1,
                color = Color.DarkGray
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PhotoHeaderPreview() {
    PhotoHeader("Sample Title", "Sample SubTitle")
}