package com.mr_alhams.cinimatoyou

import DetailsScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mr_alhams.cinimatoyou.ui.screens.HomeScreen
import com.mr_alhams.cinimatoyou.ui.screens.theater.TheaterScreen
import com.mr_alhams.cinimatoyou.ui.theme.CinimaToYouTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CinimaToYouTheme {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "homeScreen"){
                    composable("homeScreen"){ HomeScreen(navController) }
                    composable("theaterScreen"){ TheaterScreen(navController) }
                    composable("detailsScreen"){ DetailsScreen(navController) }
                }
            }
        }
    }
}
