package com.example.navexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreenUI(navController: NavHostController, id: Int = 0) {
    val exercise = DataSources().getExercises()[id]
    Scaffold(
        topBar = {
            DashboardTopAppBar(exercise)
        }
    ) {
        DashboardContentUI(it)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardTopAppBar(exercise: ExerciseType) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(exercise.name),
                style = MaterialTheme.typography.headlineLarge
            )
        },
        navigationIcon = {
            Icon(painter = painterResource(exercise.image), contentDescription = null)
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}

@Composable
fun DashboardContentUI(paddingValues: PaddingValues) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary
                    )
                )
            )
    ) {


    }
}
