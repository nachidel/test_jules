package com.productionapp.web // Adjust to your actual package name

import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import com.productionapp.web.ui.LoginScreen // Assuming LoginScreen will be created

fun main() {
    renderComposable(rootElementId = "root") {
        // MaterialTheme equivalent for Compose for Web can be more complex to set up fully.
        // For now, we'll apply basic styling.
        // Consider using a KMP UI library that supports web if advanced styling is needed.
        Style(AppStyles) // Basic styling
        AppNavigator()
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

// object Screen { // Simplified for web, or use a more robust navigation library
//     const val Login = "login"
//     const val ProductionOrders = "orders"
// }

// Basic CSS-in-JS styles
object AppStyles : StyleSheet() {
    init {
        body style {
            fontFamily("Arial, Helvetica, sans-serif")
            margin(0.px)
            padding(0.px)
            display(DisplayStyle.Flex)
            justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)
            height(100.vh)
            backgroundColor(Color("#f0f0f0"))
        }
    }
    val container by style {
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        alignItems(AlignItems.Center)
        padding(20.px)
        backgroundColor(Color.white)
        borderRadius(8.px)
        boxShadow(0.px, 2.px, 4.px, rgba(0,0,0,0.1))
    }

    val inputField by style {
        margin(8.px)
        padding(10.px)
        fontSize(16.px)
        borderRadius(4.px)
        border(1.px, LineStyle.Solid, Color("#ccc"))
    }

    val button by style {
        margin(8.px)
        padding(10.px, 20.px)
        fontSize(16.px)
        color(Color.white)
        backgroundColor(Color("#007bff"))
        border(0.px)
        borderRadius(4.px)
        cursor("pointer")
    }
}
