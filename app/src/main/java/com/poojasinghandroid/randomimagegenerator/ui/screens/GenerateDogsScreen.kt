package com.poojasinghandroid.randomimagegenerator.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.poojasinghandroid.randomimagegenerator.R
import com.poojasinghandroid.randomimagegenerator.viewmodel.DogViewModel

@Composable
fun GenerateDogsScreen(navController: NavController, viewModel: DogViewModel) {
    val dogImage by viewModel.dogImage.collectAsState()
    val errorMessage by viewModel.error.collectAsState()

    Scaffold (
        topBar = {
            CustomTopAppBar(
                title = stringResource(R.string.generate_dogs),
                showBackButton = true,
                onBackButtonClick = {
                    navController.popBackStack()
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            errorMessage?.let {
                Text(text = it, color = Color.Red, modifier = Modifier.padding(8.dp))
            }
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.height(352.dp).width(272.dp)
            ) {
                AsyncImage(
                    model = dogImage ?: "",
                    contentDescription = "Dog image",
                    modifier = Modifier.fillMaxSize()
                )
            }
            OutlinedButton(
                onClick = { viewModel.generateDogImage() },
                colors = ButtonDefaults.buttonColors(Color(66, 134, 244)),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Black
                ),
                contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
            ) {
                Text("Generate!")
            }
        }
    }
}