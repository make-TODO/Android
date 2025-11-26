package com.example.todo_only.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import androidx.compose.ui.graphics.Color
import com.example.todo_only.R

@Composable
fun SplashScreen(onDone:() -> Unit) {
    LaunchedEffect(Unit) {
        delay(1500)
        onDone()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF3E2)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id= R.drawable.todo_logo_all),
            contentDescription = "앱 로고",
            modifier = Modifier.size(240.dp)
        )
    }
}