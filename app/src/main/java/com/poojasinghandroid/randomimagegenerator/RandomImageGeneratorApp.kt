package com.poojasinghandroid.randomimagegenerator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.poojasinghandroid.randomimagegenerator.ui.screens.GenerateDogsScreen
import com.poojasinghandroid.randomimagegenerator.ui.screens.HomeScreen
import com.poojasinghandroid.randomimagegenerator.ui.screens.RecentlyGeneratedScreen
import com.poojasinghandroid.randomimagegenerator.viewmodel.DogViewModel

@Composable
fun RandomImageGeneratorApp(viewModel: DogViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("generate") { GenerateDogsScreen(navController, viewModel) }
        composable("recent") { RecentlyGeneratedScreen(navController, viewModel) }
    }
}