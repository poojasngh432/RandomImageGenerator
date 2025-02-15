package com.poojasinghandroid.randomimagegenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.poojasinghandroid.randomimagegenerator.ui.theme.RandomImageGeneratorTheme
import com.poojasinghandroid.randomimagegenerator.viewmodel.DogViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomImageGeneratorTheme {
                val viewModel: DogViewModel = hiltViewModel()
                RandomImageGeneratorApp(viewModel)
            }
        }
    }
}