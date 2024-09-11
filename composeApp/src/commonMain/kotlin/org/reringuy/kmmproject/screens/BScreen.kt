package org.reringuy.kmmproject.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.reringuy.kmmproject.navigation.childComponents.bComponent.ScreenBComponent

@Composable
fun BScreen(
    text: String,
    component: ScreenBComponent
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("ScreenB: $text")
        Button(onClick = {
            component.goBack()
        }){
            Text("Go Back")
        }
    }
}