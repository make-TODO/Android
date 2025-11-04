package com.example.todo_only

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.evaluateCubic
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp

@Composable
fun SignupScreen(
    onHomeClick: () -> Unit) {

    var id by rememberSaveable { mutableStateOf("") }
    var pw by rememberSaveable { mutableStateOf("") }
    var confirmPw by rememberSaveable { mutableStateOf("") }

    Box (
        modifier = Modifier
            .background(color = colorResource(R.color.bg))
            .fillMaxSize()
            .systemBarsPadding()
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
                    .width(165.dp)
                    .height(43.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(Modifier.height(124.dp))

            OutlinedTextField(
                value = id,
                onValueChange = {id = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 46.dp),
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                placeholder = {
                    Text(
                        text = "아이디를 생성해주세요",
                        color = colorResource(id = R.color.textBox_Gray)
                    )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = colorResource(id = R.color.type_focused_outline),
                    unfocusedIndicatorColor = colorResource(id = R.color.textBox_Gray),
                    cursorColor = colorResource(id = R.color.type_focused_outline),
                    focusedContainerColor = colorResource(id = R.color.bg),
                    unfocusedContainerColor = colorResource(id = R.color.bg),
                )
            )

            Spacer(Modifier.height(3.dp))

            Text(
                text = "영어 소문자, _ , 마침표 만 가능합니다",
                color = colorResource(id = R.color.signup_caution_red),
                fontSize = 12.sp
            )

            Spacer(Modifier.height(24.dp))


        }
    }

}