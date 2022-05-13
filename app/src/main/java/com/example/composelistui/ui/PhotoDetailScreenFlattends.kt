package com.example.composelistui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension.Companion.fillToConstraints
import coil.compose.AsyncImage
import com.example.composelistui.R
import com.example.composelistui.ui.theme.ComposeListUITheme

@Composable
fun PhotoDetailScreenFlattened(photoUrl: String) {
    ConstraintLayout(
        Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        val (
            headerAvatar,
            headerTitle,
            headerSubtitle,
            picture,
            actionBtn1,
            actionBtn2,
            spacer,
            favBtn,
            shareBtn,
            divider,
            text
        ) = createRefs()

        Box(
            Modifier
                .padding(16.dp)
                .size(42.dp)
                .clip(CircleShape)
                .background(Color.LightGray)
                .constrainAs(headerAvatar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Outlined.Face, contentDescription = "", tint = Color.DarkGray)
        }

        Text(
            modifier = Modifier
                .padding(top = 16.dp, end = 16.dp)
                .constrainAs(headerTitle) {
                    top.linkTo(parent.top)
                    start.linkTo(headerAvatar.end)
                    end.linkTo(parent.end)
                    width = fillToConstraints
                },
            text = "Title goes here",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h6
        )

        Text(
            modifier = Modifier
                .padding(end = 16.dp, bottom = 16.dp)
                .constrainAs(headerSubtitle) {
                    top.linkTo(headerTitle.bottom)
                    start.linkTo(headerAvatar.end)
                    end.linkTo(parent.end)
                    width = fillToConstraints
                },
            text = "Secondary text",
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.subtitle1,
            color = Color.DarkGray
        )

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .constrainAs(picture) {
                    top.linkTo(headerSubtitle.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            model = photoUrl,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        TextButton(
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp)
                .constrainAs(actionBtn1) {
                    top.linkTo(picture.bottom)
                    start.linkTo(parent.start)
                },
            onClick = { /*TODO*/ }) {
            Text("ACTION 1")
        }

        TextButton(
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp)
                .constrainAs(actionBtn2) {
                    top.linkTo(picture.bottom)
                    start.linkTo(actionBtn1.end)
                },
            onClick = { /*TODO*/ }) {
            Text("ACTION 2")
        }

        Box(modifier = Modifier
            .padding(top = 8.dp)
            .constrainAs(spacer) {
                top.linkTo(picture.bottom)
                start.linkTo(actionBtn2.end)
                end.linkTo(favBtn.start)
                width = fillToConstraints
            }
            .background(Color.Red))

        IconBtn(
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(favBtn) {
                    top.linkTo(picture.bottom)
                    start.linkTo(spacer.end)
                },
            onClick = { /*TODO*/ },
            imageVector = Icons.Default.Favorite
        )

        IconBtn(
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(shareBtn) {
                    top.linkTo(picture.bottom)
                    start.linkTo(favBtn.end)
                    end.linkTo(parent.end)
                },
            onClick = { /*TODO*/ },
            imageVector = Icons.Default.Share
        )

        Divider(
            Modifier
                .padding(top = 8.dp, start = 16.dp, end = 16.dp)
                .constrainAs(divider) {
                    top.linkTo(actionBtn1.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

        Text(
            modifier = Modifier
                .padding(16.dp)
                .constrainAs(text) {
                    top.linkTo(divider.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            text = stringResource(id = R.string.lorem_ipsum),
            style = MaterialTheme.typography.body1,
            color = Color.DarkGray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PhotoDetailScreenFlattenedPreview() {
    ComposeListUITheme {
        PhotoDetailScreenFlattened("https://images.unsplash.com/photo-1604782206219-3b9576575203?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8c2hhcGVzfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60")
    }
}
