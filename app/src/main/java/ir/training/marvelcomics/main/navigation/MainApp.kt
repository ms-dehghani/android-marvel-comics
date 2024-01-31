package ir.training.marvelcomics.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ir.training.marvelcomics.main.view.item.ComicItemScreen
import ir.training.marvelcomics.util.Screen

@Composable
fun MainApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController, startDestination = Screen.ComicList.name) {
        composable(Screen.ComicList.name) {

        }
        composable(
            Screen.ComicItem.name + "?comicId={comicId}",
            arguments = listOf(navArgument(
                name = "comicId"
            ) {
                type = NavType.IntType
                defaultValue = -1
            }),
        ) {
            ComicItemScreen {
                navController.navigateUp()
            }
        }
    }
}