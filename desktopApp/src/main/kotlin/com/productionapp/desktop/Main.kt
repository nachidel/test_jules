package com.productionapp.desktop // Adjust to your actual package name

import androidx.compose.material.MaterialTheme // Compose for Desktop typically uses M2
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.productionapp.desktop.ui.LoginScreen // Assuming LoginScreen will be created

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Production App - Desktop") {
        MaterialTheme { // Added MaterialTheme wrapper here
            AppNavigator()
        }
    }
}

@Composable
fun AppNavigator() {
    // For now, just show the LoginScreen. Later, this will handle navigation.
    // var currentScreen by remember { mutableStateOf(Screen.Login) }
    // when (currentScreen) {
    //     Screen.Login -> LoginScreen(onLoginSuccess = { currentScreen = Screen.ProductionOrders })
    //     Screen.ProductionOrders -> ProductionOrdersScreen(onLogout = { currentScreen = Screen.Login})
    // }
     LoginScreen(onLoginSuccess = { /* Navigate to production orders */ })
}

// sealed class Screen {
//     object Login : Screen()
//     object ProductionOrders : Screen()
// }
