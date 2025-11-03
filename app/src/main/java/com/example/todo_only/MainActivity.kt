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
                            onStartClick = {
                                nav.navigate(Routes.Login)
                            }
                        )
                    }
                    composable(Routes.Login) {
                        LoginScreen(
                            onLoginSuccess = {
                                nav.navigate(Routes.Home) {
                                    popUpTo(nav.graph.startDestinationId) { inclusive = true }
                                    launchSingleTop = true
                                }
                            },
                            onSignupSuccess = {
                                nav.navigate(Routes.Signup)
                            }
                        )
                    }
                    composable(Routes.Signup) {
                        SignupScreen(
                            onSignupSuccess = {
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


