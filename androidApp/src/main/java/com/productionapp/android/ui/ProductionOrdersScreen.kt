package com.productionapp.android.ui // Adjust to your actual package name

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer // Added this import from the previous version I created
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height // Added this import from the previous version I created
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProductionOrdersScreen(onLogout: () -> Unit) {
    // val productionViewModel: ProductionViewModel = viewModel() // Later, inject a ViewModel

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Production Orders", style = MaterialTheme.typography.headlineMedium)
        // TODO: Display list of production orders here
        Spacer(modifier = Modifier.height(16.dp)) // This line was in the prompt
        Button(onClick = onLogout) {
            Text("Log Out")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductionOrdersScreenPreview() {
    MaterialTheme {
        ProductionOrdersScreen(onLogout = {})
    }
}
