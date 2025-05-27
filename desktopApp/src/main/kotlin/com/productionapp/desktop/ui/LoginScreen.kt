package com.productionapp.desktop.ui // Adjust to your actual package name

import androidx.compose.foundation.layout.*
import androidx.compose.material.* // Using Material 2 components
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
// No standard @Preview for desktop in the same way as Android.
// Run the app to see the UI.
// For PasswordVisualTransformation if used:
// import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login - Desktop", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
            // visualTransformation = PasswordVisualTransformation() // Available in M2
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // TODO: Implement actual login logic
            onLoginSuccess()
        }) {
            Text("Log In")
        }
    }
}
