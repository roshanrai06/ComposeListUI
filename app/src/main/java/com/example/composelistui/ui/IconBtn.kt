package com.example.composelistui.ui

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun IconBtn(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    imageVector: ImageVector
) {
    IconButton(modifier = modifier, onClick = onClick) {
        Icon(
            imageVector,
            contentDescription = "Icons",
            tint = Color.Gray
        )

    }
}