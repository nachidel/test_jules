package com.productionapp.android // Adjust to your actual package name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // Included as per prompt
import androidx.compose.material3.* // Included as per prompt
import androidx.compose.runtime.* // Included as per prompt
import androidx.compose.ui.Alignment // Included as per prompt
import androidx.compose.ui.Modifier // Included as per prompt
import androidx.compose.ui.unit.dp // Included as per prompt
import com.productionapp.android.ui.LoginScreen // Added this import
import com.productionapp.android.ui.theme.ProductionAppTheme // Assuming this theme is generated

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductionAppTheme { // Assuming ProductionAppTheme exists
                AppNavigator() // We'll define this composable for navigation
            }
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
