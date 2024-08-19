package ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.features.login.LoginScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        Navigator(LoginScreen()) {
            SlideTransition(it)
        }
    }
}