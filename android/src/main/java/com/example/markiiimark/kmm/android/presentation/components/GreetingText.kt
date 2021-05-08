package com.example.markiiimark.kmm.android.presentation.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun GreetingText(name: String) {
    Text(text = "Hello $name!")
}