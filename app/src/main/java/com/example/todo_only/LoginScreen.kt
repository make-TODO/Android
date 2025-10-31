package com.example.todo_only

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDragHandle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onSignupSuccess: () -> Unit,
) {
    var id by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }
    var pwVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.bg))
            .systemBarsPadding()
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(Modifier.height(49.dp))

            Image(
                painter = painterResource(id = R.drawable.todo_logo_text),
                contentDescription = "앱 텍스트 로고",
                modifier = Modifier.size(165.dp)
            )

            Spacer(Modifier.height(180.dp))

            OutlinedTextField(
                value = id,
                onValueChange = { id = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 46.dp),
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                placeholder = {
                    Text(
                        text = "아이디를 입력해주세요",
                        color = colorResource(R.color.textBox_Gray)
                    )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = colorResource(R.color.type_focused_outline),
                    unfocusedIndicatorColor = colorResource(R.color.textBox_Gray),
                    cursorColor = colorResource(R.color.type_focused_outline),
                    focusedContainerColor = colorResource(R.color.bg),
                    unfocusedContainerColor = colorResource(R.color.bg),
                )
            )

            Spacer(Modifier.height(30.dp))

            OutlinedTextField(
                value = pw,
                onValueChange = { pw = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 46.dp),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "비밀번호를 입력해주세요",
                        color = colorResource(R.color.textBox_Gray)
                    )
                },
                shape = RoundedCornerShape(12.dp),
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
                            .clickable { pwVisible = !pwVisible },
                        contentScale = ContentScale.Fit
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = colorResource(R.color.type_focused_outline),
                    unfocusedIndicatorColor = colorResource(R.color.textBox_Gray),
                    cursorColor = colorResource(R.color.type_focused_outline),
                    focusedContainerColor = colorResource(R.color.bg),
                    unfocusedContainerColor = colorResource(R.color.bg),
                )
            )

            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "계정이 없으신가요?",
                    color = colorResource(R.color.textBox_Gray),
                    modifier = Modifier.padding(top = 34.dp)
                )

                Spacer(modifier = Modifier.width(5.dp))

                TextButton(
                    onClick = onSignupSuccess,
                    shape = RectangleShape,
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "회원가입 하러가기",
                        color = colorResource(R.color.textMain),
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier.padding(top = 34.dp)
                    )
                }
            }

            Spacer(Modifier.height(34.dp))

            Button(
                onClick = onLoginSuccess,
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                  containerColor = colorResource(R.color.btnBg),
                  contentColor = colorResource(R.color.textMain)
                ),
                modifier = Modifier
                    .width(345.dp)
                    .height(52.dp)
            ) {
                Text("로그인", fontSize = 18.sp)
            }

            Spacer(Modifier.height(261.dp))
        }
    }
}