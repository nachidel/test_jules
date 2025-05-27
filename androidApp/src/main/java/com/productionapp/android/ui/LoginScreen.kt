package com.productionapp.android.ui // Adjust to your actual package name

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
// For PasswordVisualTransformation, if you uncomment it:
// import androidx.compose.ui.text.input.PasswordVisualTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    // val authViewModel: AuthViewModel = viewModel() // Later, inject a ViewModel

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") }
            // singleLine = true // Removed as per current prompt
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }
            // singleLine = true, // Removed as per current prompt
            // visualTransformation = PasswordVisualTransformation() // For password hiding
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // TODO: Implement actual login logic using API client from shared module
            // For now, just simulate success
            onLoginSuccess()
        }) {
            Text("Log In")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    MaterialTheme { // Assuming ProductionAppTheme might not be available in preview context directly
         LoginScreen(onLoginSuccess = {})
    }
}
