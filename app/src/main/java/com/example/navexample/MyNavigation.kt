package com.example.navexample

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

sealed class Destination(val route: String) {
    object Welcome : Destination("welcome")
    object Home : Destination("home")
    object Favorites : Destination("favorites")
    object Dashboard : Destination("dashboard")
    object TaskDetail : Destination("taskDetail")
    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

@Composable
fun MyNavigationHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Welcome.route
    ) {
        composable(Destination.Welcome.route) { WelcomeScreenUI(navController) }
        composable(Destination.Home.route) { HomeScreenUI(navController) }
        composable(
            Destination.Favorites.route + "/{username}",
            arguments = listOf(
                navArgument("username") {
                    type = NavType.StringType
                }
            )
        ) {
            val name = it.arguments?.getString("username") ?: "ZBK"
            FavoritesScreenUI(navController, name)
        }
        composable(
            Destination.Dashboard.route + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) {
            val id = it.arguments?.getInt("id") ?: 0
            DashboardScreenUI(navController, id)
        }
        composable(Destination.TaskDetail.route) { TaskDetailScreenUI(navController) }
    }
}

