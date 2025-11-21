package com.example.todo_only

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp

@Composable
fun SignupScreen(
    onLoginClick: () -> Unit) {

    var id by rememberSaveable { mutableStateOf("") }
    var pw by rememberSaveable { mutableStateOf("") }
    var confirmPw by rememberSaveable { mutableStateOf("") }
    var pwVisible by remember { mutableStateOf(false) }

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

            OutlinedTextField(
                value = pw,
                onValueChange = {pw = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 46.dp),
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                placeholder = {
                    Text(
                        text = "비밀번호를 생성해주세요.",
                        color = colorResource(id = R.color.textBox_Gray)
                    )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                visualTransformation = if (pwVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
                trailingIcon = {
                    val iconRes =
                        if (pwVisible) R.drawable.pw_eye_on
                        else R.drawable.pw_eye_off

                    Image(
                        painter = painterResource(id = iconRes),
                        contentDescription = if (pwVisible) "비밀번호 숨기기" else "비밀번호 보기",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {pwVisible = !pwVisible},
                        contentScale = ContentScale.Fit
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = colorResource(id = R.color.type_focused_outline),
                    unfocusedIndicatorColor = colorResource(id = R.color.textBox_Gray),
                    cursorColor = colorResource(id = R.color.type_focused_outline),
                    focusedContainerColor = colorResource(id = R.color.bg),
                    unfocusedContainerColor = colorResource(id = R.color.bg),
                )
            )

            Spacer(Modifier.height(20.dp))

            OutlinedTextField(
                value = confirmPw,
                onValueChange = {confirmPw = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 46.dp),
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                placeholder = {
                    Text(
                        text = "비밀번호 확인",
                        color = colorResource(id = R.color.textBox_Gray)
                    )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                visualTransformation = if (pwVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
                trailingIcon = {
                    val iconRes =
                        if (pwVisible) R.drawable.pw_eye_on
                        else R.drawable.pw_eye_off

                    Image(
                        painter = painterResource(id = iconRes),
                        contentDescription = if (pwVisible) "비밀번호 숨기기" else "비밀번호 보기",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {pwVisible = !pwVisible},
                        contentScale = ContentScale.Fit
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = colorResource(id = R.color.type_focused_outline),
                    unfocusedIndicatorColor = colorResource(id = R.color.textBox_Gray),
                    cursorColor = colorResource(id = R.color.type_focused_outline),
                    focusedContainerColor = colorResource(id = R.color.bg),
                    unfocusedContainerColor = colorResource(id = R.color.bg),
                )
            )

            Spacer(Modifier.height(55.dp))

            Box(
                modifier = Modifier
                    .width(345.dp)
                    .height(46.dp)
                    .background(colorResource(id = R.color.btnBg))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        onLoginClick()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text("회원가입", fontSize = 18.sp, color = colorResource(id = R.color.textMain))
            }
        }
    }
}