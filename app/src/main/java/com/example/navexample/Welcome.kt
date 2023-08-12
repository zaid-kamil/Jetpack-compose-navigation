package com.example.navexample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun WelcomeScreenUI(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Welcome")
        Button(onClick = {
            navController.navigate(Destination.Home.route)
        }) {
            Text(text = "Click to Agree to Terms")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WelcomePreview() {
    WelcomeScreenUI(rememberNavController())
}
