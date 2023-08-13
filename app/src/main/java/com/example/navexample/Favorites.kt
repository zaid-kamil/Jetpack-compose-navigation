package com.example.navexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun FavoritesScreenUI(navController: NavHostController, username: String = "") {
    val exerciseType = DataSources().getExercises()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.tertiary
                    )
                )
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.exercise_6),
                    contentDescription = null,
                    modifier = Modifier.height(40.dp),
                    colorFilter = ColorFilter.tint(
                        MaterialTheme.colorScheme.onPrimary
                    )
                )
                Text(
                    text = "😀 Welcome, $username",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
            ) {
                items(exerciseType.size) { index ->
                    val type = exerciseType[index]
                    ExerciseCard(index, type) {
                        navController.navigate(
                            Destination.Dashboard.withArgs(it.toString())
                        )
                    }
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseCard(
    index: Int, exerciseType: ExerciseType, onSelection: (i: Int) -> Unit
) {
    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(), colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        contentColor = MaterialTheme.colorScheme.onSurface
    ), onClick = { onSelection(index) }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = exerciseType.image),
                contentDescription = null,
                modifier = Modifier.height(80.dp),

                )
            Text(
                text = stringResource(exerciseType.name),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}


//preview
@Composable
@Preview(showBackground = true)
fun FavoritesScreenUIPreview() {
    FavoritesScreenUI(rememberNavController(), "Zaid")
}