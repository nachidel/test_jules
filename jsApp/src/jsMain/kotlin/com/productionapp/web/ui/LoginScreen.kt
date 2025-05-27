package com.productionapp.web.ui // Adjust to your actual package name

import androidx.compose.runtime.*
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import com.productionapp.web.AppStyles

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Div(attrs = { classes(AppStyles.container) }) {
        H1 { Text("Login - Web") }
        Input(type = InputType.Text, attrs = {
            classes(AppStyles.inputField)
            placeholder("Username")
            value(username)
            onInput { username = it.value }
        })
        Input(type = InputType.Password, attrs = {
            classes(AppStyles.inputField)
            placeholder("Password")
            value(password)
            onInput { password = it.value }
        })
        Button(attrs = {
            classes(AppStyles.button)
            onClick {
                // TODO: Implement actual login logic
                onLoginSuccess()
            }
        }) {
            Text("Log In")
        }
    }
}
