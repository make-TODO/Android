package com.example.todo_only

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo_only.ui.theme.TodoOnlyTheme

object Routes {
    const val Splash = "splash"
    const val Intro = "intro"
    const val Login = "login"
    const val Signup = "signup"
    const val Home = "home"
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoOnlyTheme {
                val nav = rememberNavController()

                NavHost(
                    navController = nav,
                    startDestination = Routes.Splash
                ) {
                    composable(Routes.Splash) {
                        SplashScreen(
                            onDone = {
                                nav.navigate(Routes.Intro) {
                                    popUpTo(Routes.Splash) { inclusive = true }
                                }
                            }
                        )
                    }
                    composable(Routes.Intro) {
                        IntroScreen(
                            onSignupClick = {
                                nav.navigate(Routes.Signup)
                            },
                            onLoginClick = {
                                nav.navigate(Routes.Login)
                            }
                        )
                    }

                    composable(Routes.Login) {
                        LoginScreen(
                            onHomeClick = {
                                nav.navigate(Routes.Home) {
                                }
                            },
                            onSignupClick = {
                                nav.navigate(Routes.Signup)
                            }
                        )
                    }

                    composable(Routes.Signup) {
                        SignupScreen(
                            onLoginClick = {
                                nav.navigate(Routes.Login) {
                                }
                            }
                        )
                    }
                    composable(Routes.Home) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    androidx.compose.material3.Text("홈 화면입니다 🙌")
}


