package com.example.loginpage

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginpage.ui.HomeScreen
import com.example.loginpage.ui.login.LoginScreen
import com.example.loginpage.ui.signup.PolicyScreen
import com.example.loginpage.ui.signup.PrivacyScreen
import com.example.loginpage.ui.signup.SignUpScreen

sealed class Route{
    data class LoginScreen(val name: String = "Login"): Route()
    data class SignUpScreen(val name: String = "SignUp"): Route()
    data class PolicyScreen(val name: String = "Policy"): Route()
    data class PrivacyScreen(val name: String = "Privacy"): Route()
    data class HomeScreen(val name: String = "Home"): Route()

}

@Composable
fun MyNavigation(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(navController = navHostController, startDestination = Route.LoginScreen().name) {
        composable(Route.LoginScreen().name) {
            LoginScreen(
                onLoginClick = {
                    // Insert Login Validation Here
                    navHostController.navigate(
                        Route.HomeScreen().name
                    )
                },
                onSignUpClick = {
                    navHostController.navigate(
                        Route.SignUpScreen().name
                    )
                }
            )
        }
        composable(Route.SignUpScreen().name) {
            SignUpScreen(
                onLoginClick = {
                    // Insert Login Validation Here
                    navHostController.navigate(
                        Route.LoginScreen().name
                    )
                },
                onSignUpClick = {
                    navHostController.navigate(
                        Route.HomeScreen().name
                    )
                },
                onPrivacyClick = {
                    navHostController.navigate(
                        Route.PrivacyScreen().name
                    )
                },
                onPolicyClick = {
                    navHostController.navigate(
                        Route.PolicyScreen().name
                    )
                }
            )
        }
        composable(Route.PolicyScreen().name) {
            PolicyScreen {
                navHostController.navigateUp()
            }
        }
        composable(Route.PrivacyScreen().name) {
            PrivacyScreen {
                navHostController.navigateUp()
            }
        }
        composable(Route.HomeScreen().name) {
            HomeScreen()
        }

    }
}
