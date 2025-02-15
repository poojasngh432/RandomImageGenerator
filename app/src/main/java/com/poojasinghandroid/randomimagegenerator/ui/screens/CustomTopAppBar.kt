package com.poojasinghandroid.randomimagegenerator.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.poojasinghandroid.randomimagegenerator.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    title: String = "",
    showBackButton: Boolean = true,
    onBackButtonClick: () -> Unit
) {
    Column(modifier = modifier) {
        CenterAlignedTopAppBar(
            navigationIcon = {
                if (showBackButton) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.clickable(onClick = onBackButtonClick)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            tint = Color(66, 134, 244),
                            contentDescription = stringResource(R.string.back)
                        )
                        Text(
                            text = stringResource(R.string.back),
                            fontSize = 14.sp,
                            color = Color(66, 134, 244)
                        )
                    }
                }
            },
            title = { Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp) },
            modifier = Modifier.heightIn(max = 46.dp)
        )
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

/**
 * A preview function for [CustomTopAppBar].
 */
@Preview
@Composable
fun PreviewCustomTopAppBar() {
    CustomTopAppBar(
        title = "title",
        showBackButton = true,
        onBackButtonClick = {  }
    )
}