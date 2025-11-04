package com.example.todo_only


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun IntroScreen(
    onSignupClick: () -> Unit,
    onLoginClick: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.bg))
            .systemBarsPadding()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.todo_logo_all),
                contentDescription = "앱 로고",
                modifier = Modifier.size(240.dp)
            )

            Spacer(Modifier.height(12.dp))

            Text(
                text = "오늘 해야 할 일을\n마음껏 기록해보세요!",
                fontSize = 18.sp,
                color = Color(0xFF3B2F19),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(94.dp))

            Box(
                modifier = Modifier
                    .width(345.dp)
                    .height(52.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(colorResource(id = R.color.btnBg))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        onSignupClick()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "시작하기",
                    fontSize = 18.sp
                )
            }

            Spacer(Modifier.height(17.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "계정이 있으신가요?",
                    color = Color(0xFFA59C8D),
                    fontSize = 12.sp
                )

                Spacer(Modifier.width(5.dp))

                Text(
                    text = "로그인",
                    color = colorResource(id = R.color.textMain),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 12.sp,
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                    onLoginClick()
                    }
                )
            }

            Spacer(Modifier.height(20.dp))
        }
    }
}