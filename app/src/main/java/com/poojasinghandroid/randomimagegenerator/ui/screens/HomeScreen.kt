package com.poojasinghandroid.randomimagegenerator.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.poojasinghandroid.randomimagegenerator.R

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(stringResource(R.string.random_dog_gen))
        Spacer(modifier = Modifier.height(72.dp))
        OutlinedButton(
            onClick = { navController.navigate("generate") },
            colors = ButtonDefaults.buttonColors(Color(66, 134, 244)),
            border = BorderStroke(
                width = 1.dp,
                color = Color.Black
            ),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Text(stringResource(R.string.generate_dogs))
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = { navController.navigate("recent")},
            colors = ButtonDefaults.buttonColors(Color(66, 134, 244)),
            border = BorderStroke(
                width = 1.dp,
                color = Color.Black
            ),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
        ) {
            Text(stringResource(R.string.my_recently_generated))
        }
    }
}