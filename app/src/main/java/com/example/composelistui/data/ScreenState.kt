package com.example.composelistui.data

sealed class ScreenState {
    object LIST : ScreenState()
    object GRID : ScreenState()
    data class Details(val photoUrl: String) : ScreenState()
}