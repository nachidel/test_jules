package com.productionapp.web.ui // Adjust to your actual package name

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.* // Included for potential styling, though AppStyles is used
import org.jetbrains.compose.web.dom.*
import com.productionapp.web.AppStyles

@Composable
fun ProductionOrdersScreen(onLogout: () -> Unit) {
    Div(attrs = { classes(AppStyles.container) }) {
        H1 { Text("Production Orders - Web") }
        // TODO: Display list of production orders here
        Br() // As per prompt
        Button(attrs = {
            classes(AppStyles.button)
            onClick { onLogout() }
        }) {
            Text("Log Out")
        }
    }
}
