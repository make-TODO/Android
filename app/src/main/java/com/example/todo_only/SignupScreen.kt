package com.example.todo_only

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun SignupScreen(
    onSignupSuccess: () -> Unit) {

    var id by rememberSaveable { mutableStateOf("") }
    var pw by rememberSaveable { mutableStateOf("") }
    var confirmPw by rememberSaveable { mutableStateOf("") }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(color = colorResource(R.color.bg))
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Spacer(Modifier.height(49.dp))

            Image(
                painter = painterResource(id = R.drawable.todo_logo_text),
                contentDescription = "앱 텍스트 로고",
                modifier = Modifier
                    .size(165.dp)
                    .fillMaxWidth(),
            )

            Spacer(Modifier.height(124.dp))

        }
    }

}