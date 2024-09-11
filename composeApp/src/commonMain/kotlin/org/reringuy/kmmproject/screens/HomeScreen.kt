package org.reringuy.kmmproject.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import org.reringuy.kmmproject.navigation.childComponents.homeComponent.ScreenHomeComponent
import org.reringuy.kmmproject.navigation.childComponents.homeComponent.ScreenHomeEvent

@Composable
fun HomeScreen(component: ScreenHomeComponent) {
    val text by component.text.subscribeAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text("Home")
        OutlinedTextField(
            value = text,
            onValueChange = { component.onEvent(ScreenHomeEvent.UpdateText(it)) },
            modifier = Modifier
                .width(200.dp)
                .padding(12.dp)
        )
        Button(onClick = {
            component.onEvent(ScreenHomeEvent.ClickButton)
        }){
            Text("Go to ScreenB",
                style = MaterialTheme.typography.body2)
        }
    }
}