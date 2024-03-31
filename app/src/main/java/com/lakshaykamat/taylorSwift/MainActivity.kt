package com.lakshaykamat.taylorSwift

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lakshaykamat.taylorSwift.models.Screen
import com.lakshaykamat.taylorSwift.screens.*
import com.lakshaykamat.taylorSwift.ui.theme.TaylorSwiftTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaylorSwiftTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.rout) {
        composable(Screen.Home.rout) {
            HomeScreen(navController)
        }

        composable(Screen.Album.rout) {
            AlbumScreen(navController)
        }

        composable(
            Screen.Song.rout + "/{albumName}",
            arguments = listOf(
                navArgument("albumName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            SongScreen(navController = navController, backStackEntry = backStackEntry)
        }


        composable(Screen.Quote.rout) {
            QuoteScreen(navController)
        }

        composable(
            Screen.SongInfo.rout + "/{songName}",
            arguments = listOf(
                navArgument("songName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            SongInformationScreen(navController, backStackEntry = backStackEntry)
        }
    }

}
