package com.productionapp.desktop.ui // Adjust to your actual package name

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductionOrdersScreen(onLogout: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Production Orders - Desktop", style = MaterialTheme.typography.h5)
        // TODO: Display list of production orders here
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onLogout) {
            Text("Log Out")
        }
    }
}
