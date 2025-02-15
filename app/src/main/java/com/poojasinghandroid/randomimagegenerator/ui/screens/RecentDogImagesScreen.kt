package com.poojasinghandroid.randomimagegenerator.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.poojasinghandroid.randomimagegenerator.R
import com.poojasinghandroid.randomimagegenerator.viewmodel.DogViewModel

@Composable
fun RecentlyGeneratedScreen(navController: NavController, viewModel: DogViewModel) {
    val cachedDogImages by viewModel.cachedDogImages.collectAsState()
    val errorMessage by viewModel.error.collectAsState()

    Scaffold (
        topBar = {
            CustomTopAppBar(
                title = stringResource(R.string.my_recently_generated),
                showBackButton = true,
                onBackButtonClick = {
                    navController.popBackStack()
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            errorMessage?.let {
                Text(text = it, color = Color.Red, modifier = Modifier.padding(8.dp))
            }
            Spacer(modifier = Modifier.height(72.dp))
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(cachedDogImages) { imageUrl ->
                        AsyncImage(
                            model = imageUrl,
                            contentDescription = "Cached Dog Images",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(270.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            OutlinedButton(
                onClick = { viewModel.clearCache() },
                colors = ButtonDefaults.buttonColors(Color(66, 134, 244)),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Black
                ),
                contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
            ) {
                Text("clear Dogs!")
            }
        }
    }
}